package com.valmar.ecommerce.daoimpl;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.util.DateUtil;
import com.valmar.ecommerce.dao.TokenDao;
import com.valmar.ecommerce.model.Token;
import com.valmar.ecommerce.model.Usuario;

@Repository("tokenDao")
@EnableTransactionManagement
public class TokenDaoImpl extends AbstractDao<Integer, Token> implements TokenDao {

	private static final int expireTimeInSeconds = 1200;
	private static final String USERNAME = "u.correo";

	@Override
	public String generarToken(Usuario usuario) {
		Token token = new Token();
		/*
		 * This works by choosing 130 bits from a cryptographically secure
		 * random bit generator, and encoding them in base-32. 128 bits is
		 * considered to be cryptographically strong, but each digit in a base
		 * 32 number can encode 5 bits, so 128 is rounded up to the next
		 * multiple of 5. This encoding is compact and efficient, with 5 random
		 * bits per character. Compare this to a random UUID, which only has 3.4
		 * bits per character in standard layout, and only 122 random bits in
		 * total.
		 */
		SecureRandom random = new SecureRandom();
		String authToken = new BigInteger(130, random).toString(32);
		token.setAuthToken(authToken);
		/**
		 * Current Date
		 */
		token.setIssuedOn(new Timestamp(new Date().getTime()));
		/*
		 * Current and Add expire time to it
		 */
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, expireTimeInSeconds);
		token.setExpiresOn(new Timestamp(calendar.getTimeInMillis()));
		token.setUser(usuario);

		Query query = getSession().createSQLQuery("INSERT INTO token " + "(authToken, issuedOn, expiresOn, userId ) "
				+ "VALUES (:authToken, :issuedOn, :expiresOn, :userId )");
		query.setParameter("authToken", token.getAuthToken());
		query.setParameter("issuedOn", token.getIssuedOn());
		query.setParameter("expiresOn", token.getExpiresOn());
		query.setParameter("userId", token.getUser().getId());
		query.executeUpdate();
		return token.getAuthToken();
	}

	@Override
	public boolean validarToken(String tokenId) {
		boolean isValidated = false; 
		try {
			Query query = getSession().createSQLQuery(
					"SELECT * FROM token t " + "WHERE t.AuthToken = :authToken " + "AND t.ExpiresOn > :currentDate");
			query.setString("authToken", tokenId);
			query.setTimestamp("currentDate", new Timestamp(new Date().getTime()));
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if ((results != null) && (!results.isEmpty())) {
				Token token = new Token();
				for (Object[] row : results) {
					token.setId(Long.parseLong(row[0].toString()));
					token.setAuthToken(row[1].toString());
					token.setIssuedOn(DateUtil.getDateFromString(row[2].toString()));
					token.setExpiresOn(DateUtil.getDateFromString(row[3].toString()));
				}
				//Refresh the Expires date of token
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.SECOND, expireTimeInSeconds);
				token.setExpiresOn(new Timestamp(calendar.getTimeInMillis()));

				Query queryToUpdate = getSession().createSQLQuery(
						"UPDATE token t " + "SET t.ExpiresOn = :expiresOn " + "WHERE t.authToken = :authToken");
				queryToUpdate.setParameter("expiresOn", token.getExpiresOn());
				queryToUpdate.setParameter("authToken", token.getAuthToken());
				queryToUpdate.executeUpdate();
				isValidated = true;
			}
		} catch (Exception ex) {
			return isValidated;
		}
		return isValidated;
	}

	@Override
	public String obtenerUsuarioPorToken(String token) {
		String userName = "";
		try {
			Query query = getSession().createSQLQuery("SELECT " + USERNAME + " FROM usuario u "
					+ "INNER JOIN token t ON u.id = t.userId " + "WHERE t.authToken = :authToken");
			query.setString("authToken", token);
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if(!results.isEmpty()){
				Object obj = results.get(0);
				userName = (String) obj;
			}
		} catch (Exception ex) {
			return null;
		}
		return userName;
	}

}

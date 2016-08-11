package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.AuthorityDao;
import com.valmar.ecommerce.model.Authority;

@Repository("authorityDao")
@EnableTransactionManagement
public class AuthorityDaoImpl extends AbstractDao<Integer, Authority> implements AuthorityDao{

	@Override
	public List<Authority> obtenerRolesPorUsuario(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.createAlias("usuarios", "u");
			criteria.add(Restrictions.eq("u.id", id));
			List<Authority> items = (List<Authority>) criteria.list();
			return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

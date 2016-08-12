package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.BancoDao;
import com.valmar.ecommerce.model.Banco;

@Repository("bancoDao")
@EnableTransactionManagement
public class BancoDaoImpl extends AbstractDao<Integer, Banco> implements BancoDao{
	
	@Override
	public Banco obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Banco) criteria.uniqueResult();
	}

	@Override
	public List<Banco> listarBancos() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Banco> bancos = (List<Banco>) criteria.list();
		return bancos;
	}

	@Override
	public List<Banco> listarPorTienda(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.createAlias("tiendas", "t");
			criteria.add(Restrictions.eq("t.id", id));			
			List<Banco> bancos = (List<Banco>) criteria.list();
			return bancos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

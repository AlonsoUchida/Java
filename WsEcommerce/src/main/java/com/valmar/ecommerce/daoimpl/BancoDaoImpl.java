package com.valmar.ecommerce.daoimpl;

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

}

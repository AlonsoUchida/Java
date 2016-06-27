package com.valmar.ecommerce.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.DistritoDao;
import com.valmar.ecommerce.model.Distrito;


@Repository("distritoDao")
@EnableTransactionManagement
public class DistritoDaoImpl extends AbstractDao<Integer, Distrito> implements DistritoDao{

	@Override
	public Distrito obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Distrito) criteria.uniqueResult();
	}

}

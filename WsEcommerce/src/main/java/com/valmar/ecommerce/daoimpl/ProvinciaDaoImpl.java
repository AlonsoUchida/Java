package com.valmar.ecommerce.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ProvinciaDao;
import com.valmar.ecommerce.model.Provincia;


@Repository("provinciaDao")
@EnableTransactionManagement
public class ProvinciaDaoImpl extends AbstractDao<Integer, Provincia> implements ProvinciaDao{

	@Override
	public Provincia obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Provincia) criteria.uniqueResult();
	}

}

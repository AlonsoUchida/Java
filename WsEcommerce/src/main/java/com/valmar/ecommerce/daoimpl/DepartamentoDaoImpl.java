package com.valmar.ecommerce.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.DepartamentoDao;
import com.valmar.ecommerce.model.Departamento;


@Repository("deparatamentoDao")
@EnableTransactionManagement
public class DepartamentoDaoImpl extends AbstractDao<Integer, Departamento> implements DepartamentoDao{

	@Override
	public Departamento obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Departamento) criteria.uniqueResult();
	}

}

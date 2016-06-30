package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.DepartamentoDao;
import com.valmar.ecommerce.model.Departamento;
import com.valmar.ecommerce.model.Provincia;


@Repository("deparatamentoDao")
@EnableTransactionManagement
public class DepartamentoDaoImpl extends AbstractDao<Integer, Departamento> implements DepartamentoDao{

	@Override
	public Departamento obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Departamento) criteria.uniqueResult();
	}

	@Override
	public List<Departamento> listarDepartamentos() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Departamento> departamentos = (List<Departamento>) criteria.list();
		return departamentos;
	}

}

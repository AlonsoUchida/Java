package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ProvinciaDao;
import com.valmar.ecommerce.model.Distrito;
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

	@Override
	public List<Provincia> listarProvincias() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Provincia> provincias = (List<Provincia>) criteria.list();
		return provincias;
	}

	@Override
	public List<Provincia> listarPorDepartamento(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("departamento.id", id));
		List<Provincia> provincias = (List<Provincia>) criteria.list();
		return provincias;
	}

	@Override
	public Provincia obtenerProvinciaPorDistrito(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("distritos", "d");
		criteria.add(Restrictions.eq("d.id", id));
		return (Provincia) criteria.uniqueResult();
	}

}

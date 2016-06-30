package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.DistritoDao;
import com.valmar.ecommerce.model.Categoria;
import com.valmar.ecommerce.model.Direccion;
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

	@Override
	public List<Distrito> obtenerDitritosPorProvincia(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("provincia.id", id));
			List<Distrito> distritos = (List<Distrito>) criteria.list();			
			return distritos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Distrito> listarDistritos() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Distrito> distritos = (List<Distrito>) criteria.list();
		return distritos;
	}

}

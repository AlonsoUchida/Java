package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.MarcaDao;
import com.valmar.ecommerce.model.Marca;

@Repository("marcaDao")
@EnableTransactionManagement
public class MarcaDaoImpl extends AbstractDao<Integer, Marca> implements MarcaDao{

	@Override
	public Marca obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Marca) criteria.uniqueResult();
	}

	@Override
	public List<Marca> listarMarcas() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Marca> marcas = (List<Marca>) criteria.list();
		return marcas;
	}
}

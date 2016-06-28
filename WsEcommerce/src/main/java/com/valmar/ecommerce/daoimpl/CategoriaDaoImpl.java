package com.valmar.ecommerce.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.CategoriaDao;
import com.valmar.ecommerce.model.Categoria;

@Repository("categoriaDao")
@EnableTransactionManagement
public class CategoriaDaoImpl extends AbstractDao<Integer, Categoria> implements CategoriaDao{

	@Override
	public Categoria obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Categoria) criteria.uniqueResult();
	}

}

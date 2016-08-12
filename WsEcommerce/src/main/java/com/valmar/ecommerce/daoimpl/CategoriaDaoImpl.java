package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.CategoriaDao;
import com.valmar.ecommerce.model.Categoria;
import com.valmar.ecommerce.model.ImagenTienda;

@Repository("categoriaDao")
@EnableTransactionManagement
public class CategoriaDaoImpl extends AbstractDao<Integer, Categoria> implements CategoriaDao{

	@Override
	public Categoria obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Categoria) criteria.uniqueResult();
	}

	@Override
	public List<Categoria> listarCategorias() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Categoria> categorias = (List<Categoria>) criteria.list();
		return categorias;
	}

	@Override
	public List<Categoria> listarPorTienda(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			/*criteria.add(Restrictions.eq("tienda.id", id));			*/
			List<Categoria> categorias = (List<Categoria>) criteria.list();
			return categorias;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

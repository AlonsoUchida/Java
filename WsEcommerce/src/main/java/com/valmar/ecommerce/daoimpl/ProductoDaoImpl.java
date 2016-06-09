package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ProductoDao;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.model.Tienda;

@Repository("productoDao")
@EnableTransactionManagement
public class ProductoDaoImpl extends AbstractDao<Integer, Producto> implements ProductoDao{

	@Override
	public Producto obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Producto) criteria.uniqueResult();
	}

	@Override
	public void agregar(Producto producto) {
		try {
			persist(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("delete from PRODUCTO where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Producto> listarProductos() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Producto> productos = (List<Producto>) criteria.list();
			return productos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

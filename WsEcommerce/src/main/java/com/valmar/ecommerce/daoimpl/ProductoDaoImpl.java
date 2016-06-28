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
	public void actualizar(Producto producto) {
		try {
			merge(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void eliminar(int id) {
		try {
			
			Query query1 = getSession().createSQLQuery("delete from producto_categoria where id_producto = :id");
			query1.setInteger("id", id);
			query1.executeUpdate();
			
			Query query2 = getSession().createSQLQuery("delete from imagen_producto where id_producto = :id");
			query2.setInteger("id", id);
			query2.executeUpdate();
		
			Query query3 = getSession().createSQLQuery("delete from producto where id = :id");
			query3.setInteger("id", id);
			query3.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Producto> listarProductos() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			@SuppressWarnings("unchecked")
			List<Producto> productos = (List<Producto>) criteria.list();
			return productos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Producto obtenerPorNombre(String nombre) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nombre", nombre));
		return (Producto) criteria.uniqueResult();
	}

	@Override
	public List<Producto> obtenerProductosPorTienda(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("tienda.id", id));
			@SuppressWarnings("unchecked")
			List<Producto> productos = (List<Producto>) criteria.list();
			return productos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

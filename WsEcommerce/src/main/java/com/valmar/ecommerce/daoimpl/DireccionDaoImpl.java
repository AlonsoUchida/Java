package com.valmar.ecommerce.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.DireccionDao;
import com.valmar.ecommerce.model.Direccion;


@Repository("direccionDao")
@EnableTransactionManagement
public class DireccionDaoImpl extends AbstractDao<Integer, Direccion> implements DireccionDao {

	@Override
	public Direccion obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Direccion) criteria.uniqueResult();
	}

	@Override
	public void agregar(Direccion direccion) {
		try {
			persist(direccion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actualizar(Direccion direccion) {
		try {
			merge(direccion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query1 = getSession().createSQLQuery("delete from cliente_direccion where id_direccion = :id");
			query1.setInteger("id", id);
			query1.executeUpdate();
			
			Query query2 = getSession().createSQLQuery("delete from tienda_direccion where id_direccion = :id");
			query2.setInteger("id", id);
			query2.executeUpdate();
			
			Query query3 = getSession().createSQLQuery("delete from direccion where id = :id");
			query3.setInteger("id", id);
			query3.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Direccion> listarDirecciones() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Direccion> direcciones = (List<Direccion>) criteria.list();
			return direcciones;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Direccion> obtenerDireccionesTiendasPorDistrito(int id) {
		List<Direccion> direcciones = new ArrayList<>();
		try {
			Query query = getSession().createSQLQuery("select d.* from tienda t " 
					+ " inner join tienda_direccion td "
					+ " on t.id = td.id_tienda " + "inner join direccion d " 
					+ " on td.id_direccion = d.id"
					+ " inner join distrito dist" 
					+ " on d.id_distrito = dist.id" 
					+ " where dist.id = :id");
			query.setInteger("id", id);
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if ((results != null) && (!results.isEmpty())) {				
				for (Object[] row : results) {
					Direccion direccion = new Direccion();
					direccion.setId(Integer.parseInt(row[0].toString()));
					direccion.setLatitud(row[5].toString());
					direccion.setLongitud(row[6].toString());
					direcciones.add(direccion);
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return direcciones;
	}

	@Override
	public List<Direccion> listarPorTienda(Integer id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.createAlias("tiendas", "t");
			criteria.add(Restrictions.eq("t.id", id));
			List<Direccion> direcciones = (List<Direccion>) criteria.list();
			return direcciones;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

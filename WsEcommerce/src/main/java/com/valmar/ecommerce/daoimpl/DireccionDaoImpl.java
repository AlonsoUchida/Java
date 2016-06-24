package com.valmar.ecommerce.daoimpl;

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
			Query query = getSession().createSQLQuery("delete from direccion where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
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

}

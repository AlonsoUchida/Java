package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.TiendaDao;
import com.valmar.ecommerce.model.Tienda;

@Repository("tiendaDao")
@EnableTransactionManagement
public class TiendaDaoImpl extends AbstractDao<Integer, Tienda> implements TiendaDao{

	@Override
	public Tienda obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Tienda) criteria.uniqueResult();
	}

	@Override
	public void agregar(Tienda tienda) {
		try {
			persist(tienda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("delete from tienda where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Tienda> listarTiendas() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

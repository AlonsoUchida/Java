package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.TiendaDao;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Tienda;

@Repository("tiendaDao")
@EnableTransactionManagement
public class TiendaDaoImpl extends AbstractDao<Integer, Tienda> implements TiendaDao {

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

			Query query1 = getSession().createSQLQuery("delete from tienda_metodo_pago where id_tienda = :id");
			query1.setInteger("id", id);
			query1.executeUpdate();

			Query query2 = getSession().createSQLQuery("delete from tienda_envio where id_tienda = :id");
			query2.setInteger("id", id);
			query2.executeUpdate();

			Query query3 = getSession().createSQLQuery("delete from estado_cuenta where id_tienda = :id");
			query3.setInteger("id", id);
			query3.executeUpdate();

			Query query4 = getSession().createSQLQuery("delete from producto where id_tienda = :id");
			query4.setInteger("id", id);
			query4.executeUpdate();

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

	@Override
	public void actualizar(Tienda tiendaBean) {
		try {
			merge(tiendaBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Tienda obtenerTiendaPorDireccion(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("direcciones", "d");
		criteria.add(Restrictions.eq("d.id", id));
		return (Tienda) criteria.uniqueResult();
	}

	@Override
	public List<Tienda> obtenerTiendasPorNombre(String nombre) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.ilike("nombre", "%"+nombre+"%"));
			criteria.setMaxResults(20);//Los primeros 20 elementos por defecto
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}

package com.valmar.ecommerce.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.TiendaDao;
import com.valmar.ecommerce.enums.TipoEstado;
import com.valmar.ecommerce.enums.TipoUsuario;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.ImagenTienda;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.viewmodel.TiendaVMLite2;

@Repository("tiendaDao")
@EnableTransactionManagement
public class TiendaDaoImpl extends AbstractDao<Integer, Tienda> implements TiendaDao {

	@Override
	public Tienda obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
		return (Tienda) criteria.uniqueResult();
	}

	@Override
	public int agregar(Tienda tienda) {
		try {
			persist(tienda);
			return tienda.getId();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("update tienda set estado = 2 where id = :id");
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
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("direccionesTienda", "d");
		criteria.add(Restrictions.eq("d.id", id));
		criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
		return (Tienda) criteria.uniqueResult();
	}

	@Override
	public List<Tienda> obtenerTiendasPorNombre(String nombre) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.ilike("nombre", "%"+nombre+"%"));
			//criteria.setMaxResults(20);//Los primeros 20 elementos por defecto
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tienda> listarPorDistrito(int id) {	
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.createAlias("direccionesTienda", "d");
			//criteria.createAlias("envios", "e");
			criteria.add(Restrictions.eq("d.distrito.id", id));
			//criteria.setMaxResults(20);//Los primeros 20 elementos por defecto
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tienda> obtenerTiendasPorNombreDistrito(String nombre, int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.ilike("nombre", "%"+nombre+"%"));
			criteria.createAlias("direccionesTienda", "d");
			//criteria.createAlias("envios", "e");
			criteria.add(Restrictions.eq("d.distrito.id", id));
			//criteria.setMaxResults(20);//Los primeros 20 elementos por defecto
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tienda> listarPorVendedor(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.createAlias("usuarios", "u");
			//criteria.createAlias("envios", "e");
			criteria.add(Restrictions.eq("u.tipo", TipoUsuario.VENDEDOR.getValue()));
			criteria.add(Restrictions.eq("u.id", id));
			//criteria.setMaxResults(20);//Los primeros 20 elementos por defecto
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tienda> obtenerTiendasPorNombreDistritoUrbanizacion(String nombre, int id, int id_urbanizacion) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.ilike("nombre", "%"+nombre+"%"));
			criteria.createAlias("direccionesTienda", "d");
			//criteria.createAlias("envios", "e");
			if(id_urbanizacion==0)
				criteria.add(Restrictions.eq("d.distrito.id", id));
			else
				criteria.add(Restrictions.eq("d.urbanizacion.id", id));
			
			//criteria.setMaxResults(20);//Los primeros 20 elementos por defecto
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tienda> listarPorBodeguero(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.createAlias("usuarios", "u");
			criteria.add(Restrictions.eq("u.id", id));
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Tienda> tiendas = (List<Tienda>) criteria.list();
			return tiendas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TiendaVMLite2> listarTodosTiendasPorCobertura() {
		List<TiendaVMLite2> tiendas = new ArrayList<>();
		try {
			Query query = getSession().createSQLQuery("select t.id, t.nombre, t.estado_abierto, d.domicilio, d.numero,  di.nombre as distrito, d.latitud, d.longitud from tienda t "
						+ " inner join  tienda_direccion td on t.id = td.id_tienda "
						+ " left join direccion d on td.id_direccion = d.id "
						+ " left join distrito di on d.id_distrito = di.id "
						+ " left join imagen_tienda it on t.id = it.id_tienda "
						+ " where t.estado = :estado "
						+ " group by t.id");
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if(results!=null){				
				for(Object[] item : results){
					TiendaVMLite2 tienda = new TiendaVMLite2();	
					tienda.setId(Integer.parseInt(item[0].toString()));
					tienda.setNombre(item[1].toString());
					int estado = Integer.parseInt(item[2].toString());
					if(estado==1)
						tienda.setEstado("Abierto");
					else if(estado==2)
						tienda.setEstado("Cerrado");
					tienda.setDireccion(item[3].toString() + " " + item[4].toString() + ", "+ item[5].toString());
					tienda.setLatitud(item[6].toString());
					tienda.setLongitud(item[7].toString());
					tiendas.add(tienda);					
				}
				
			}
		} catch (Exception ex) {
			return null;
		}
		return tiendas;
	}
	

}

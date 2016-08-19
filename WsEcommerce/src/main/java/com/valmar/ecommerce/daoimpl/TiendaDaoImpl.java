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
import com.valmar.ecommerce.viewmodel.TiendaVMLite;

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
	public List<TiendaVMLite> listarTodosTiendasPorCobertura() {
		List<TiendaVMLite> tiendas = new ArrayList<>();
		try {
			Query query = getSession().createSQLQuery("select t.id, t.nombre, t.estado_abierto, d.domicilio, d.numero,  di.nombre as distrito, d.latitud, d.longitud, d.id as id_distrito, it.imagen from tienda t "
						+ " inner join  tienda_direccion td on t.id = td.id_tienda "
						+ " left join direccion d on td.id_direccion = d.id "
						+ " left join distrito di on d.id_distrito = di.id "
						+ " left join imagen_tienda it on t.id = it.id_tienda "
						+ " where t.estado = :estado "
						+ " group by  t.id, d.id, it.id");
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if(results!=null){				
				for(Object[] item : results){
					if(item!=null){
						TiendaVMLite tienda = new TiendaVMLite();
						String nombre = item[1]!=null ? item[1].toString() : "";
						String estado = item[2]!=null ? ((Integer.parseInt(item[2].toString()) == 1) ? "Abierto" : "Cerrado") : "";
						String domicilio = item[3]!=null ? item[3].toString() : "";
						String numero = item[4]!=null ? item[4].toString() : "";
						String distrito = item[5]!=null ? item[5].toString() : "";
						String latitud = item[6]!=null ? item[6].toString() : "";
						String longitud = item[7]!=null ? item[7].toString() : "";
						String imagen = item[9]!=null ? item[9].toString() : "";
						
						tienda.setId(Integer.parseInt(item[0].toString()));
						tienda.setNombre(nombre);
						tienda.setEstado(estado);						
						tienda.setDireccion(domicilio + " " + numero + ", "+ distrito);
						tienda.setLatitud(latitud);
						tienda.setLongitud(longitud);
						tienda.setImagen(imagen);
						tiendas.add(tienda);	
					}
				}
				
			}
		} catch (Exception ex) {
			return null;
		}
		return tiendas;
	}

	@Override
	public List<TiendaVMLite> obtenerTiendasPorNombreDistrito2(String nombre, int id) {
		List<TiendaVMLite> tiendas = new ArrayList<>();
		try {
			Query query = getSession().createSQLQuery("select t.id, t.nombre, t.estado_abierto, d.domicilio, d.numero,  di.nombre as distrito, d.latitud, d.longitud, d.id as id_distrito, it.imagen from tienda t "
						+ " inner join  tienda_direccion td on t.id = td.id_tienda "
						+ " left join direccion d on td.id_direccion = d.id "
						+ " left join distrito di on d.id_distrito = di.id "
						+ " left join imagen_tienda it on t.id = it.id_tienda "
						+ " where t.estado = :estado and t.nombre like :nombre and di.id = :distrito_id"
						+ " group by  t.id, d.id, it.id");
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			String containsNombre = "%" + nombre + "%";
			query.setString("nombre", containsNombre);
			query.setInteger("distrito_id", id);
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if(results!=null){				
				for(Object[] item : results){
					if(item!=null){
						TiendaVMLite tienda = new TiendaVMLite();
						String _nombre = item[1]!=null ? item[1].toString() : "";
						String estado = item[2]!=null ? ((Integer.parseInt(item[2].toString()) == 1) ? "Abierto" : "Cerrado") : "";
						String domicilio = item[3]!=null ? item[3].toString() : "";
						String numero = item[4]!=null ? item[4].toString() : "";
						String distrito = item[5]!=null ? item[5].toString() : "";
						String latitud = item[6]!=null ? item[6].toString() : "";
						String longitud = item[7]!=null ? item[7].toString() : "";
						String imagen = item[9]!=null ? item[9].toString() : "";
						
						tienda.setId(Integer.parseInt(item[0].toString()));
						tienda.setNombre(_nombre);
						tienda.setEstado(estado);						
						tienda.setDireccion(domicilio + " " + numero + ", "+ distrito);
						tienda.setLatitud(latitud);
						tienda.setLongitud(longitud);
						tienda.setImagen(imagen);
						tiendas.add(tienda);	
					}
				}
				
			}
		} catch (Exception ex) {
			return null;
		}
		return tiendas;
	}

	@Override
	public List<TiendaVMLite> obtenerTiendasPorNombre2(String nombre) {
		List<TiendaVMLite> tiendas = new ArrayList<>();
		try {
			Query query = getSession().createSQLQuery("select t.id, t.nombre, t.estado_abierto, d.domicilio, d.numero,  di.nombre as distrito from tienda t "
						+ " inner join  tienda_direccion td on t.id = td.id_tienda "
						+ " left join direccion d on td.id_direccion = d.id "
						+ " left join distrito di on d.id_distrito = di.id "
						+ " left join imagen_tienda it on t.id = it.id_tienda "
						+ " where t.estado = :estado and t.nombre like :nombre "
						+ " group by  t.id, d.id, it.id");
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			String containsNombre = "%" + nombre + "%";
			query.setString("nombre", containsNombre);
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if(results!=null){				
				for(Object[] item : results){
					if(item!=null){
						TiendaVMLite tienda = new TiendaVMLite();
						String _nombre = item[1]!=null ? item[1].toString() : "";				
						String domicilio = item[3]!=null ? item[3].toString() : "";
						String numero = item[4]!=null ? item[4].toString() : "";
						String distrito = item[5]!=null ? item[5].toString() : "";
					
						tienda.setId(Integer.parseInt(item[0].toString()));
						tienda.setNombre(_nombre);					
						tienda.setDireccion(domicilio + " " + numero + ", "+ distrito);
						tiendas.add(tienda);	
					}
				}
				
			}
		} catch (Exception ex) {
			return null;
		}
		return tiendas;
	}
	

}

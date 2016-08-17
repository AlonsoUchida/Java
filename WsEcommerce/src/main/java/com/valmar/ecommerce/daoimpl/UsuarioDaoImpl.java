package com.valmar.ecommerce.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.UsuarioDao;
import com.valmar.ecommerce.enums.TipoEstado;
import com.valmar.ecommerce.enums.TipoUsuario;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.viewmodel.ReporteVM;

@Repository("usuarioDao")
@EnableTransactionManagement
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	private Usuario mapearUsuario(Object[] results){
		if(results!=null){
			Usuario usuario = new Usuario();		
			usuario.setId(Integer.parseInt(results[0].toString()));
			usuario.setNombre(results[1].toString());
			usuario.setApellido(results[2].toString());
			usuario.setCorreo(results[3].toString());
			usuario.setPassword(results[4].toString());
			usuario.setTipo(Integer.parseInt(results[6].toString()));
			return usuario;
		}
		return null;
	}
	
	@Override
	public Usuario obtenerPorId(int id) {
		Usuario usuario;
		try {
			Query query = getSession().createSQLQuery("SELECT * FROM usuario WHERE id = :id and "
					+ " estado = :estado ");
			query.setInteger("id", id);
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			@SuppressWarnings("unchecked")
			Object[] results = (Object[]) query.uniqueResult();
			usuario = mapearUsuario(results);
		} catch (Exception ex) {
			return null;
		}
		return usuario;
	}

	@Override
	public int agregar(Usuario usuario) {
		int id = 0;
		try {
			persist(usuario);
			id = usuario.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public void actualizar(Usuario usuario) {
		try {
			merge(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("update usuario set estado = 2 where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> listarUsuarios() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Usuario> usuarios = (List<Usuario>) criteria.list();			
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int validarUsuario(String username, String password){
		Usuario usuario = new Usuario();
		int userID = 0;
		try {
			Query query = getSession().createSQLQuery("SELECT * FROM usuario WHERE correo = :correo and password = :password and"
					+ " estado = :estado ");
			query.setString("correo", username);
			query.setString("password", password);
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			@SuppressWarnings("unchecked")
			Object[] results = (Object[]) query.uniqueResult();
			if(results!=null){
				userID = Integer.parseInt(results[0].toString());
			}
		} catch (Exception ex) {
			return userID;
		}
		return userID;
	}
	
	public Usuario obtenerPorCorreo(String username) {
		Usuario usuario;
		try {
			Query query = getSession().createSQLQuery("SELECT * FROM usuario WHERE correo = :correo and "
					+ " estado = :estado ");
			query.setString("correo", username);
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			@SuppressWarnings("unchecked")
			Object[] results = (Object[]) query.uniqueResult();
			usuario = mapearUsuario(results);
		} catch (Exception ex) {
			return null;
		}
		return usuario;
	}

	@Override
	public List<Usuario> listarBodegueros() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("tipo", TipoUsuario.BODEGUERO.getValue()));
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Usuario> usuarios = (List<Usuario>) criteria.list();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> listarVendedores() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("tipo", TipoUsuario.VENDEDOR.getValue()));
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Usuario> usuarios = (List<Usuario>) criteria.list();			
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario obtenerPorCorreoVendedor(String username) {
		Usuario usuario;
		try {
			Query query = getSession().createSQLQuery("SELECT * FROM usuario WHERE correo = :correo and "
					+ "(tipo = :tipoVendedor or tipo = :tipoAdministrador) and estado = :estado ");
			query.setString("correo", username);
			query.setInteger("tipoVendedor", TipoUsuario.VENDEDOR.getValue());
			query.setInteger("tipoAdministrador", TipoUsuario.ADMINISTRADOR.getValue());
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			@SuppressWarnings("unchecked")
			Object[] results = (Object[]) query.uniqueResult();
			usuario = mapearUsuario(results);
		} catch (Exception ex) {
			return null;
		}
		return usuario;
	}

	@Override
	public List<Usuario> listarUsuariosPorVendedor(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("usuario.id", id));
			criteria.add(Restrictions.eq("tipo", TipoUsuario.BODEGUERO.getValue()));
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Usuario> usuarios = (List<Usuario>) criteria.list();			
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario obtenerPorCorreoCliente(String username) {
		Usuario usuario;
		try {
			Query query = getSession().createSQLQuery("SELECT * FROM usuario WHERE correo = :correo and "
					+ "(tipo = :tipoVendedor or tipo = :tipoCliente or tipo = :tipoAdministrador) and estado = :estado ");
			query.setString("correo", username);
			query.setInteger("tipoCliente", TipoUsuario.CLIENTE.getValue());
			query.setInteger("tipoVendedor", TipoUsuario.VENDEDOR.getValue());
			query.setInteger("tipoAdministrador", TipoUsuario.ADMINISTRADOR.getValue());
			query.setInteger("estado", TipoEstado.HABILITADO.getValue());
			@SuppressWarnings("unchecked")
			Object[] results = (Object[]) query.uniqueResult();
			usuario = mapearUsuario(results);
		} catch (Exception ex) {
			return null;
		}
		return usuario;
	}

	@Override
	public List<ReporteVM> obtenerReporteRegistrosPorVendedor(int id) {
		List<ReporteVM> reportes = new ArrayList<>();
		try {
			Query query = getSession().createSQLQuery("select u.id, u.nombre, u.apellido, t.nombre as tienda, t.horario_atencion, d.domicilio, d.numero, di.nombre as distrito, u.fecha_registro " 
														+ " from usuario u "
														+ " left join  tienda_usuario tu on u.id = tu.id_usuario "
														+ " left join tienda t on tu.id_tienda = t.id "
														+ " left join tienda_direccion td on t.id = td.id_tienda "
														+ " left join direccion d on td.id_direccion = d.id "
														+ " left join distrito di on d.id_distrito = di.id "
														+ " left join imagen_tienda i on t.id = i.id_tienda "
														+ " where u.id_usuario = :id");
			query.setInteger("id", id);
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.list();
			if(results!=null){				
				for(Object[] item : results){
					if(item!=null){ 
						ReporteVM reporte = new ReporteVM();
						String tienda = item[3]!=null ? item[3].toString() : "";
						String horario = item[4]!=null ? item[4].toString() : "";
						String domicilio = item[5]!=null ? item[5].toString() : "";
						String numero = item[6]!=null ? item[6].toString() : "";
						String distrito = item[7]!=null ? item[7].toString() : "";
						String fechaRegistro = item[8]!=null ? item[8].toString() : "";
						
						reporte.setId(Integer.parseInt(item[0].toString()));
						reporte.setNombre(item[1].toString());
						reporte.setApellido(item[2].toString());
						reporte.setTienda(tienda);
						reporte.setHorario(horario);
						String stringForamatted = String.format("%s %s", domicilio, numero);
						reporte.setDireccion(stringForamatted);
						reporte.setDistrito(distrito);
						reporte.setFechaRegistro(fechaRegistro);
						reportes.add(reporte);
					}
				}
			}
			
		} catch (Exception ex) {
			return null;
		}
		return reportes;
	}


}

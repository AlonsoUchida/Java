package com.valmar.ecommerce.daoimpl;

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

@Repository("usuarioDao")
@EnableTransactionManagement
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	private Usuario mapearUsuario(Object[] results){
		Usuario usuario = new Usuario();
		if(results!=null){
			usuario.setId(Integer.parseInt(results[0].toString()));
			usuario.setNombre(results[1].toString());
			usuario.setApellido(results[2].toString());
			usuario.setCorreo(results[3].toString());
			usuario.setPassword(results[4].toString());
			usuario.setTipo(Integer.parseInt(results[6].toString()));
		}
		return usuario;
		
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
					+ "(tipo = :tipoVendedor or tipo = :tipoAdministrador) and estado = :estado ");
			query.setString("correo", username);
			query.setString("password", password);
			query.setInteger("tipoVendedor", TipoUsuario.VENDEDOR.getValue());
			query.setInteger("tipoAdministrador", TipoUsuario.ADMINISTRADOR.getValue());
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


}

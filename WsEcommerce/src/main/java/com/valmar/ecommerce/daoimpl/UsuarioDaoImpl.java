package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@Override
	public Usuario obtenerPorId(int id) {
		//Como el obtener usuario consulta po rid no es necesario crear filtro por tipo
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Usuario) criteria.uniqueResult();
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
			Query query = getSession().createSQLQuery("delete from usuario where id = :id");
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
			List<Usuario> usuarios = (List<Usuario>) criteria.list();			
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int validarUsuario(String username, String password){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("correo", username));
		criteria.add(Restrictions.eq("password", password));
		Usuario usuario = (Usuario) criteria.uniqueResult();
		if(usuario!=null)
			return usuario.getId();
		else return 0;
	}
	
	public Usuario obtenerPorCorreo(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("correo", username)); 
		Usuario usuario = (Usuario)criteria.uniqueResult();
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


}

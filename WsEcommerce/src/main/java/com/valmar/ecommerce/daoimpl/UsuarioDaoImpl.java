package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.UsuarioDao;
import com.valmar.ecommerce.model.Usuario;

@Repository("usuarioDao")
@EnableTransactionManagement
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	@Override
	public Usuario obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Usuario) criteria.uniqueResult();
	}

	@Override
	public void agregar(Usuario usuario) {
		try {
			persist(usuario);
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

	public int validateUser(String username, String password){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("login", username));
		criteria.add(Restrictions.eq("password", password));
		Usuario usuario = (Usuario) criteria.uniqueResult();
		return usuario.getId().intValue();
	}

	@Override
	public Usuario getUserById(int userId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("id",(long)userId)); 
		Usuario usuario = (Usuario)criteria.uniqueResult();
		return usuario;
	}
	
	public Usuario findByUsername(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("login", username)); 
		Usuario usuario = (Usuario)criteria.uniqueResult();
		return usuario;
	}


}

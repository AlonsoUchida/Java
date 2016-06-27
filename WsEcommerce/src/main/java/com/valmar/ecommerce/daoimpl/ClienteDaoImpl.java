package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ClienteDao;
import com.valmar.ecommerce.enums.TipoEstado;
import com.valmar.ecommerce.enums.TipoUsuario;
import com.valmar.ecommerce.model.Usuario;


@Repository("clienteDao")
@EnableTransactionManagement
public class ClienteDaoImpl extends AbstractDao<Integer, Usuario> implements ClienteDao {

	@Override
	public Usuario obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		criteria.add(Restrictions.eq("tipo", TipoUsuario.CLIENTE.getValue()));
		criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
		return (Usuario) criteria.uniqueResult();
	}

	@Override
	public void agregar(Usuario cliente) {
		try {
			persist(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public void actualizar(Usuario cliente) {
		try {
			merge(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try {
			//Query query = getSession().createSQLQuery("delete from usuario where id = :id");
			Query query = getSession().createSQLQuery("update usuario set estado = 2 where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarClientes() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("tipo", TipoUsuario.CLIENTE.getValue()));
			criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
			List<Usuario> clientes = (List<Usuario>) criteria.list();
			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario obtenerPorCorreo(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("correo", username)); 
		criteria.add(Restrictions.eq("tipo", TipoUsuario.CLIENTE.getValue()));
		criteria.add(Restrictions.eq("estado", TipoEstado.HABILITADO.getValue()));
		Usuario cliente = (Usuario)criteria.uniqueResult();
		return cliente;
	}



}

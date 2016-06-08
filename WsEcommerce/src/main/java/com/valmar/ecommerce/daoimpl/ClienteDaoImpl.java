package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ClienteDao;
import com.valmar.ecommerce.model.Cliente;


@Repository("clienteDao")
@EnableTransactionManagement
public class ClienteDaoImpl extends AbstractDao<Integer, Cliente> implements ClienteDao {

	@Override
	public Cliente obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Cliente) criteria.uniqueResult();
	}

	@Override
	public void agregar(Cliente nota) {
		try {
			persist(nota);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("delete from CLIENTE where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarClientes() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Cliente> clientes = (List<Cliente>) criteria.list();
			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

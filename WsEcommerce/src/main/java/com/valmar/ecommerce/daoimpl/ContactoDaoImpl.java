package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ContactoDao;
import com.valmar.ecommerce.model.Contacto;

@Repository("contactoDao")
@EnableTransactionManagement
public class ContactoDaoImpl extends AbstractDao<Integer, Contacto> implements ContactoDao{

	@Override
	public Contacto obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Contacto) criteria.uniqueResult();
	}

	@Override
	public void agregar(Contacto contacto) {
		try {
			persist(contacto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(Contacto contacto) {
		try {
			merge(contacto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		try {
			Query query = getSession().createSQLQuery("delete from contactos where id = :id");
			query.setInteger("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Contacto> listarContactos() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Contacto> contactos = (List<Contacto>) criteria.list();
			return contactos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

}

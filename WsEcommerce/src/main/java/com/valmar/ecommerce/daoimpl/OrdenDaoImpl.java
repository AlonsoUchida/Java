package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.OrdenDao;
import com.valmar.ecommerce.model.Orden;


@Repository("ordenDao")
@EnableTransactionManagement
public class OrdenDaoImpl extends AbstractDao<Integer, Orden> implements OrdenDao{

	@Override
	public List<Orden> listarOrdenes(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("informacionCliente", "c");
		criteria.add(Restrictions.eq("c.cliente.id", id));
		List<Orden> ordenes = (List<Orden>) criteria.list();
		return ordenes;
	}

}

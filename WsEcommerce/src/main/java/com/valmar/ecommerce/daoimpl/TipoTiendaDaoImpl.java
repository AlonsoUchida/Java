package com.valmar.ecommerce.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.TipoTiendaDao;
import com.valmar.ecommerce.model.TipoTienda;

@Repository("tipoTiendaDao")
@EnableTransactionManagement
public class TipoTiendaDaoImpl extends AbstractDao<Integer, TipoTienda> implements TipoTiendaDao{

	@Override
	public TipoTienda obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (TipoTienda) criteria.uniqueResult();
	}

}

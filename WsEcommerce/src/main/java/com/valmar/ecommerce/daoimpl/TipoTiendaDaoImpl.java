package com.valmar.ecommerce.daoimpl;

import java.util.List;

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

	@Override
	public List<TipoTienda> listarPorTienda(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.createAlias("tiendas", "t");
			criteria.add(Restrictions.eq("t.id", id));			
			List<TipoTienda> categorias = (List<TipoTienda>) criteria.list();
			return categorias;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

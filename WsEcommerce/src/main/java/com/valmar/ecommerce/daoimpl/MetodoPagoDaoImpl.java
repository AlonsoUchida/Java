package com.valmar.ecommerce.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.MetodoPagoDao;
import com.valmar.ecommerce.model.Envio;
import com.valmar.ecommerce.model.MetodoPago;

@Repository("metodoPagoDao")
@EnableTransactionManagement
public class MetodoPagoDaoImpl extends AbstractDao<Integer, MetodoPago> implements MetodoPagoDao{

	@Override
	public MetodoPago obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (MetodoPago) criteria.uniqueResult();
	}
	
	@Override
	public void agregar(MetodoPago metodoPago) {
		try{
			persist(metodoPago);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}

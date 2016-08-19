package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.HoraDao;
import com.valmar.ecommerce.model.Horas;


@Repository("horaDao")
@EnableTransactionManagement
public class HoraDaoImpl extends AbstractDao<Integer, Horas> implements HoraDao{

	@Override
	public List<Horas> listar() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Horas> horas = (List<Horas>) criteria.list();
		return horas;
	}

}

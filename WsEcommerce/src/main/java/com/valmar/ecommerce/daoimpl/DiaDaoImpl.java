package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.DiaDao;
import com.valmar.ecommerce.model.Dias;


@Repository("diaDao")
@EnableTransactionManagement
public class DiaDaoImpl extends AbstractDao<Integer, Dias> implements DiaDao{

	@Override
	public List<Dias> listar() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Dias> dias = (List<Dias>) criteria.list();
		return dias;
	}

}

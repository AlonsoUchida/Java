package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.HorarioDao;
import com.valmar.ecommerce.model.Horarios;

@Repository("horarioDao")
@EnableTransactionManagement
public class HorarioDaoImpl extends AbstractDao<Integer, Horarios> implements HorarioDao{

	@Override
	public List<Horarios> obtenerHorariosPorTienda(int id) {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("tienda.id", id));
			List<Horarios> horarios = (List<Horarios>) criteria.list();
			return horarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void agregar(Horarios horario) {
		try {			
			persist(horario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

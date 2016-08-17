package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.ReporteDiarioDao;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.model.ReporteDiario;

@Repository("reporteDiarioDao")
@EnableTransactionManagement
public class ReporteDiarioDaoImpl extends AbstractDao<Integer, ReporteDiario> implements ReporteDiarioDao{

	@Override
	public void agregar(ReporteDiario reporte) {
		try {
			persist(reporte);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ReporteDiario> listar() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			@SuppressWarnings("unchecked")
			List<ReporteDiario> items = (List<ReporteDiario>) criteria.list();
			return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

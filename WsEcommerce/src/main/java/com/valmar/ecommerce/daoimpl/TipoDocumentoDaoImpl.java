package com.valmar.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.TipoDocumentoDao;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.TipoDocumento;

@Repository("tipoDocumentoDao")
@EnableTransactionManagement
public class TipoDocumentoDaoImpl extends AbstractDao<Integer, TipoDocumento> implements TipoDocumentoDao{

	@Override
	public TipoDocumento obtenerPorId(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (TipoDocumento) criteria.uniqueResult();
	}

	@Override
	public List<TipoDocumento> listar() {
		try {
			Criteria criteria = createEntityCriteria();
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<TipoDocumento> tipoDocumentos = (List<TipoDocumento>) criteria.list();
			return tipoDocumentos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}

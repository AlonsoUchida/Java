package com.valmar.ecommerce.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.valmar.ecommerce.dao.AbstractDao;
import com.valmar.ecommerce.dao.TipoDocumentoDao;
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


}

package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.TipoDocumentoDao;
import com.valmar.ecommerce.model.TipoDocumento;
import com.valmar.ecommerce.services.TipoDocumentoService;

@Service("tipoDocumentoService")
@Transactional
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

	@Autowired
	TipoDocumentoDao tipoDocumentoDao; 
	
	@Override
	public TipoDocumento obtenerPorId(int id) {
		return tipoDocumentoDao.obtenerPorId(id);
	}

	@Override
	public List<TipoDocumento> listar() {
		return tipoDocumentoDao.listar();
	}

}

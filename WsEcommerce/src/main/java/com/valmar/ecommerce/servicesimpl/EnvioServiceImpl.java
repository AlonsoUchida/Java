package com.valmar.ecommerce.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.EnvioDao;
import com.valmar.ecommerce.model.Envio;
import com.valmar.ecommerce.services.EnvioService;

@Service("envioService")
@Transactional
public class EnvioServiceImpl implements EnvioService{

	@Autowired
	EnvioDao envioDao;
	
	@Override
	public void agregar(Envio envio) {
		envioDao.agregar(envio);
	}

}

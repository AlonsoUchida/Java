package com.valmar.ecommerce.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.BancoDao;
import com.valmar.ecommerce.model.Banco;
import com.valmar.ecommerce.services.BancoService;

@Service("bancoService")
@Transactional
public class BancoServiceImpl implements BancoService{

	@Autowired
	BancoDao bancoDao;
	
	@Override
	public Banco obtenerPorId(int id) {
		return bancoDao.obtenerPorId(id);
	}

}

package com.valmar.ecommerce.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.MetodoPagoDao;
import com.valmar.ecommerce.model.MetodoPago;
import com.valmar.ecommerce.services.MetodoPagoService;

@Service("metodoPagoService")
@Transactional
public class MetodoPagoServiceImpl implements MetodoPagoService{

	@Autowired
	MetodoPagoDao metodoPagoDao;
	
	@Override
	public MetodoPago obtenerPorId(int id) {
		return metodoPagoDao.obtenerPorId(id);
	}

	@Override
	public void agregar(MetodoPago metodoPago) {
		metodoPagoDao.agregar(metodoPago);
	}

}

package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.TipoTiendaDao;
import com.valmar.ecommerce.model.TipoTienda;
import com.valmar.ecommerce.services.TipoTiendaService;

@Service("tipoTiendaService")
@Transactional
public class TipoTiendaServiceImpl implements TipoTiendaService{

	@Autowired
	TipoTiendaDao tipoTiendaDao;
	
	@Override
	public TipoTienda obtenerPorId(int id) {
		return tipoTiendaDao.obtenerPorId(id);
	}

	@Override
	public List<TipoTienda> listarPorTienda(int id) {
		return tipoTiendaDao.listarPorTienda(id);
	}

}

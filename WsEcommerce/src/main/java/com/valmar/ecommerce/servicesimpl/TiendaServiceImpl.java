package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.TiendaDao;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.services.TiendaService;


@Service("tiendaService")
@Transactional
public class TiendaServiceImpl implements TiendaService{

	@Autowired
	TiendaDao tiendaDao;
	
	@Override
	public Tienda obtenerPorId(int id) {
		return tiendaDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Tienda tienda) {
		tiendaDao.agregar(tienda);
	}

	@Override
	public void eliminar(int id) {
		tiendaDao.eliminar(id);
	}

	@Override
	public List<Tienda> listarTiendas() {
		return tiendaDao.listarTiendas();
	}

}

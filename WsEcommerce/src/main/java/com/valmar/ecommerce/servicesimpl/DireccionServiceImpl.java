package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.valmar.ecommerce.dao.DireccionDao;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.services.DireccionService;


@Service("direccionService")
@Transactional
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionDao direccionDao;
	
	@Override
	public Direccion obtenerPorId(int id) {
		return direccionDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Direccion cliente) {
		direccionDao.agregar(cliente);		
	}

	@Override
	public void eliminar(int id) {
		direccionDao.eliminar(id);
		
	}

	@Override
	public List<Direccion> listarDirecciones() {
		return direccionDao.listarDirecciones();
	}


}

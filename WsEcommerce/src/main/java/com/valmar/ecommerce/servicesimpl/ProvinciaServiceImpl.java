package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ProvinciaDao;
import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.services.ProvinciaService;

@Service("provinciaService")
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService{

	@Autowired
	ProvinciaDao provinciaDao;
	
	@Override
	public List<Provincia> listarProvincias() {
		return provinciaDao.listarProvincias();
	}

	@Override
	public List<Provincia> listarPorDepartamento(int id) {
		return provinciaDao.listarPorDepartamento(id);
	}

	@Override
	public Provincia obtenerProvinciaPorDistrito(int id) {
		return provinciaDao.obtenerProvinciaPorDistrito(id);
	}

}

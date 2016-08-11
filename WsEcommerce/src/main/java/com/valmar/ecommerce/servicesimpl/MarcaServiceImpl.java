package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.MarcaDao;
import com.valmar.ecommerce.model.Marca;
import com.valmar.ecommerce.services.MarcaService;

@Service("marcaService")
@Transactional
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	private MarcaDao marcaDao;
	
	@Override
	public List<Marca> listarMarcas() {
		return marcaDao.listarMarcas();
	}

	@Override
	public Marca obtenerMarcaPorId(int id) {
		return marcaDao.obtenerPorId(id);
	}
}

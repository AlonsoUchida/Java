package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.CategoriaDao;
import com.valmar.ecommerce.model.Categoria;
import com.valmar.ecommerce.services.CategoriaService;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public Categoria obtenerCategoriaPorId(int id) {
		return categoriaDao.obtenerPorId(id);
	}

	@Override
	public List<Categoria> listarCategorias() {
		return categoriaDao.listarCategorias();
	}

	@Override
	public List<Categoria> listarPorTienda(int id) {
		return categoriaDao.listarPorTienda(id);
	}
	
}

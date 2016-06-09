package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ProductoDao;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.services.ProductoService;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public Producto obtenerPorId(int id) {
		return productoDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Producto producto) {
		productoDao.agregar(producto);
		
	}

	@Override
	public void eliminar(int id) {
		productoDao.eliminar(id);
	}

	@Override
	public List<Producto> listarProductos() {
		return productoDao.listarProductos();
	}

}

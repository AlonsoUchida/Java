package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.CategoriaDao;
import com.valmar.ecommerce.dao.ImagenProductoDao;
import com.valmar.ecommerce.dao.MarcaDao;
import com.valmar.ecommerce.dao.ProductoDao;
import com.valmar.ecommerce.dao.TiendaDao;
import com.valmar.ecommerce.model.Categoria;
import com.valmar.ecommerce.model.ImagenProducto;
import com.valmar.ecommerce.model.Marca;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.services.ProductoService;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoDao productoDao;
	@Autowired
	private MarcaDao marcaDao;
	@Autowired
	private TiendaDao tiendaDao;
	@Autowired
	private CategoriaDao categoriaDao;
	@Autowired
	private ImagenProductoDao imagenDao;
	
	@Override
	public Producto obtenerPorId(int id) {
		return productoDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Producto producto) {
		productoDao.agregar(producto);		
	}
	
	@Override
	public void actualizar(Producto producto) {
		productoDao.actualizar(producto);
	}
	
	@Override
	public void eliminar(int id) {
		productoDao.eliminar(id);
	}

	@Override
	public List<Producto> listarProductos() {
		return productoDao.listarProductos();
	}

	@Override
	public Producto obtenerPorNombre(String nombre) {
		return productoDao.obtenerPorNombre(nombre);
	}

	@Override
	public Marca obtenerMarcaPorId(int id) {
		return marcaDao.obtenerPorId(id);
	}

	@Override
	public Tienda obtenerTiendaPorId(int id) {
		return tiendaDao.obtenerPorId(id);
	}

	@Override
	public Categoria obtenerCategoriaPorId(int id) {
		return categoriaDao.obtenerPorId(id);
	}

	@Override
	public List<Producto> obtenerProductosPorTienda(int id) {
		return productoDao.obtenerProductosPorTienda(id);
	}

	@Override
	public ImagenProducto obtenerImagenPorDefecto(int id) {
		return imagenDao.obtenerImagenPorDefecto(id);
	}
	
}

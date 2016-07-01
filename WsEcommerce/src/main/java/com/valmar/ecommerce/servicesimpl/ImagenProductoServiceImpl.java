package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ImagenProductoDao;
import com.valmar.ecommerce.model.ImagenProducto;
import com.valmar.ecommerce.services.ImagenProductoService;

@Service("imagenProductoService")
@Transactional
public class ImagenProductoServiceImpl implements ImagenProductoService{
	
	@Autowired
	private ImagenProductoDao imagenProductoDao;
	
	@Override
	public List<ImagenProducto> listarImagenes() {
		return imagenProductoDao.listarImagenes();
	}

	@Override
	public ImagenProducto obtenerImagenPorId(int id) {
		return imagenProductoDao.obtenerPorId(id);
	}

	@Override
	public void agregarImagen(ImagenProducto imagen) {
		imagenProductoDao.agregarImagen(imagen);		
	}

	@Override
	public void actualizarImagen(ImagenProducto imagen) {
		imagenProductoDao.actualizarImagen(imagen);		
	}

	@Override
	public void eliminarImagen(int id) {
		imagenProductoDao.eliminar(id);
	}

	@Override
	public List<ImagenProducto> listarImagenesPorProducto(int id) {
		return imagenProductoDao.listarImagenesPorProducto(id);
	}
}

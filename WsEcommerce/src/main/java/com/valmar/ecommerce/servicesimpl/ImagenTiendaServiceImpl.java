package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ImagenTiendaDao;
import com.valmar.ecommerce.model.ImagenTienda;
import com.valmar.ecommerce.services.ImagenTiendaService;

@Service("imagenTiendaService")
@Transactional
public class ImagenTiendaServiceImpl implements ImagenTiendaService{

	@Autowired
	private ImagenTiendaDao imagenTiendaDao;
	
	@Override
	public List<ImagenTienda> listarImagenes() {
		return imagenTiendaDao.listarImagenes();
	}

	@Override
	public ImagenTienda obtenerImagenPorId(int id) {
		return imagenTiendaDao.obtenerPorId(id);
	}

	@Override
	public void agregarImagen(ImagenTienda imagen) {
		imagenTiendaDao.agregarImagen(imagen);		
	}

	@Override
	public void actualizarImagen(ImagenTienda imagen) {
		imagenTiendaDao.actualizarImagen(imagen);		
	}

	@Override
	public void eliminarImagen(int id) {
		imagenTiendaDao.eliminar(id);
	}

	@Override
	public List<ImagenTienda> listarImagenesPorTienda(int id) {
		return imagenTiendaDao.listarImagenesPorTienda(id);
	}
	
}

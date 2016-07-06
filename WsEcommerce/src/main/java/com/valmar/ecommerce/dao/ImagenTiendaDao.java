package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.ImagenTienda;

public interface ImagenTiendaDao {
	List<ImagenTienda> listarImagenes();
	ImagenTienda obtenerPorId(int id);
	void agregarImagen(ImagenTienda imagen);
	void actualizarImagen(ImagenTienda imagen);
	void eliminar(int id);
	ImagenTienda obtenerImagenPorDefecto(int id);
	List<ImagenTienda> listarImagenesPorTienda(int id);
}

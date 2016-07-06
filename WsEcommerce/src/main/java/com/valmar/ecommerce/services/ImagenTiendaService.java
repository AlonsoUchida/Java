package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.ImagenTienda;

public interface ImagenTiendaService {

	List<ImagenTienda> listarImagenes();
	ImagenTienda obtenerImagenPorId(int id);
    void agregarImagen(ImagenTienda imagen);
    void actualizarImagen(ImagenTienda imagen);
    void eliminarImagen(int id);
	List<ImagenTienda> listarImagenesPorTienda(int id);
}

package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.ImagenProducto;

public interface ImagenProductoService {
	List<ImagenProducto> listarImagenes();
    ImagenProducto obtenerImagenPorId(int id);
    void agregarImagen(ImagenProducto imagen);
    void actualizarImagen(ImagenProducto imagen);
    void eliminarImagen(int id);
	List<ImagenProducto> listarImagenesPorProducto(int id);
}

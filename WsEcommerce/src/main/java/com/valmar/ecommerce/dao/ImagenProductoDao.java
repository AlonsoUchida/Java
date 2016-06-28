package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.ImagenProducto;

public interface ImagenProductoDao {
	  List<ImagenProducto> listarImagenes();
	  ImagenProducto obtenerPorId(int id);
	  void agregarImagen(ImagenProducto imagen);
	  void actualizarImagen(ImagenProducto imagen);
	  void eliminar(int id);
}

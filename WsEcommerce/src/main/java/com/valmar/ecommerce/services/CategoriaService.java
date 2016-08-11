package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Categoria;

public interface CategoriaService {
	Categoria obtenerCategoriaPorId(int id);
	List<Categoria> listarCategorias();
}

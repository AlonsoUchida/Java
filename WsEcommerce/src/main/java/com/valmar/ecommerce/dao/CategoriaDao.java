package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Categoria;

public interface CategoriaDao {
	Categoria obtenerPorId(int id);
	List<Categoria> listarCategorias();
	List<Categoria> listarPorTienda(int id);
}

package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Marca;

public interface MarcaDao {
	Marca obtenerPorId(int id);
	List<Marca> listarMarcas();
}

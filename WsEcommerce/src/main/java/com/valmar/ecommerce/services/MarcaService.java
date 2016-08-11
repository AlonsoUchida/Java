package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Marca;

public interface MarcaService {

	Marca obtenerMarcaPorId(int id);  
	List<Marca> listarMarcas();
}

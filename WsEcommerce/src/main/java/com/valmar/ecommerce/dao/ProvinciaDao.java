package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Provincia;

public interface ProvinciaDao {

	Provincia obtenerPorId(int id);
	List<Provincia> listarProvincias();
	List<Provincia> listarPorDepartamento(int id);
	Provincia obtenerProvinciaPorDistrito(int id);
}

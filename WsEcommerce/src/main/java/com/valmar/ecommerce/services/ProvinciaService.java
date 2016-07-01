package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Provincia;

public interface ProvinciaService {
	List<Provincia> listarProvincias();
	List<Provincia> listarPorDepartamento(int id);
}

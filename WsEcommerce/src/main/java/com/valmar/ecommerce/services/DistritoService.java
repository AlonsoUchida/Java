package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.Provincia;

public interface DistritoService {
	List<Distrito> listarDistritos();
	List<Distrito> listarPorProvincia(int id);
	Distrito obtenerPorId(int id_distrito);
}

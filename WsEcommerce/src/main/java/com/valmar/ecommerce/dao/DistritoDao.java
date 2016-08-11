package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Distrito;

public interface DistritoDao {

	Distrito obtenerPorId(int id);
	List<Distrito> listarDistritos();
	List<Distrito> obtenerDitritosPorProvincia(int id);
}

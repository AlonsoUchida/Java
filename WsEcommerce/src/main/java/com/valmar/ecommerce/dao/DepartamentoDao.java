package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Departamento;

public interface DepartamentoDao {

	Departamento obtenerPorId(int id);
	List<Departamento> listarDepartamentos();
	Departamento obtenerDepartamentoPorProvincia(int id);
}

package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Orden;

public interface OrdenDao {
	List<Orden> listarOrdenes(int id);
}

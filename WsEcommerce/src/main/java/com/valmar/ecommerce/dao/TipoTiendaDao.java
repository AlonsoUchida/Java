package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.TipoTienda;

public interface TipoTiendaDao {
	TipoTienda obtenerPorId(int id);
	List<TipoTienda> listarPorTienda(int id);
}

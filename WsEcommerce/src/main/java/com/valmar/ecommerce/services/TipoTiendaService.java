package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.TipoTienda;

public interface TipoTiendaService {
	TipoTienda obtenerPorId(int id);
	List<TipoTienda> listarPorTienda(int id);
}

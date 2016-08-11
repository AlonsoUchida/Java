package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Orden;

public interface OrdenService {
	List<Orden> listarOrdenes(int id);
}

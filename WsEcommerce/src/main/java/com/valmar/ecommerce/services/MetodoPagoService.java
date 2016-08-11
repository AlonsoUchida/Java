package com.valmar.ecommerce.services;

import com.valmar.ecommerce.model.MetodoPago;

public interface MetodoPagoService {
	MetodoPago obtenerPorId(int id);
	void agregar(MetodoPago metodoPago);
}

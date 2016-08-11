package com.valmar.ecommerce.dao;

import com.valmar.ecommerce.model.MetodoPago;

public interface MetodoPagoDao {
	MetodoPago obtenerPorId(int id);
	void agregar(MetodoPago metodoPago);
}

package com.valmar.ecommerce.dao;

import com.valmar.ecommerce.model.Envio;

public interface EnvioDao {
	void agregar(Envio envio);
	Envio obtenerPorId(int id_envio);
}

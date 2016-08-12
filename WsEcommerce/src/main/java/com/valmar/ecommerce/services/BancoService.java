package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Banco;
import com.valmar.ecommerce.model.Categoria;

public interface BancoService {
	
	Banco obtenerPorId(int id);
	List<Banco> listarBancos();
	List<Banco> listarPorTienda(int id);
}

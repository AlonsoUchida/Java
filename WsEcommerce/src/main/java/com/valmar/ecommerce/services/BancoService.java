package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Banco;

public interface BancoService {
	
	Banco obtenerPorId(int id);
	List<Banco> listarBancos();
}

package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Banco;

public interface BancoDao {
	Banco obtenerPorId(int id);
	List<Banco> listarBancos();
	List<Banco> listarPorTienda(int id);
}

package com.valmar.ecommerce.dao;

import com.valmar.ecommerce.model.Usuario;

public interface TokenDao {
	public String generarToken(Usuario usuario);
	public boolean validarToken(String tokenId);
	public String obtenerUsuarioPorToken(String token);
}

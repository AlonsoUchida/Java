package com.valmar.ecommerce.dao;

import com.valmar.ecommerce.model.Usuario;

public interface TokenDao {
	public String generateToken(Usuario user);
	public boolean validateToken(String tokenId);
	public String getUsernameFromToken(String token);
}

package com.valmar.ecommerce.dao;

import com.valmar.ecommerce.model.Usuario;

public interface UserDao {
	public int validateUser(String username, String password);	
	public Usuario getUserById(int userId);
	public Usuario findByUsername(String username);
	
}

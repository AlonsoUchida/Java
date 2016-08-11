package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Authority;

public interface AuthorityDao {
	List<Authority> obtenerRolesPorUsuario(int id);
}

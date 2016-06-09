package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Usuario;

public interface UsuarioDao {
	Usuario obtenerPorId(int id);	 
    void agregar(Usuario usuario);     
    void eliminar(int id);    
    List<Usuario> listarUsuarios();
}

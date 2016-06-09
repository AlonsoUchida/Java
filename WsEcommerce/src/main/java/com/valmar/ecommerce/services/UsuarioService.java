package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Usuario;

public interface UsuarioService {
	Usuario obtenerPorId(int id);	 
    void agregar(Usuario usuario);     
    void eliminar(int id);    
    List<Usuario> listarUsuarios();
}

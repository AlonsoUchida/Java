package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Usuario;

public interface UsuarioDao {
	
	Usuario obtenerPorId(int id);	 
    int agregar(Usuario usuario);  
    void actualizar(Usuario usuario);
    void eliminar(int id);    
    List<Usuario> listarUsuarios();
    List<Usuario> listarBodegueros();
    
    int validarUsuario(String username, String password);	
	Usuario obtenerPorCorreo(String username);
	List<Usuario> listarVendedores();
	Usuario obtenerPorCorreoVendedor(String username);
	List<Usuario> listarUsuariosPorVendedor(int id);
	Usuario obtenerPorCorreoCliente(String username);
}

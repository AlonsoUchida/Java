package com.valmar.ecommerce.services;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.valmar.ecommerce.model.Usuario;

public interface UsuarioService {
	Usuario obtenerPorId(int id);	 
    int agregar(Usuario usuario);  
    void actualizar(Usuario usuario);
    void eliminar(int id);    
    List<Usuario> listarUsuarios();
    
    public int validarUsuario(String username, String password);
	public String generarToken(int userId);
	public boolean validarToken(String token);
	public String obtenerUsuarioPorToken(String token);
	Usuario obtenerPorCorreo(String username);
	List<Usuario> listarVendedores();
	//Validar al vendedor
	Usuario obtenerPorCorreoVendedor(String username);
	List<Usuario> listarUsuariosPorVendedor(int id);
}

package com.valmar.ecommerce.services;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.valmar.ecommerce.model.Usuario;

public interface UsuarioService {
	Usuario obtenerPorId(int id);	 
    void agregar(Usuario usuario);     
    void eliminar(int id);    
    List<Usuario> listarUsuarios();
    
    public int validateUser(String username, String password);
	public String generateToken(int userId);
	public boolean validateToken(String token);
	public String getUsernameFromToken(String token);
	Usuario loadUserByUsername(String username) throws UsernameNotFoundException;
}

package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Usuario;

public interface ClienteService {	

	Usuario obtenerPorId(int id);	 
    void agregar(Usuario cliente); 
    void actualizar(Usuario cliente);
    void eliminar(int id);    
    List<Usuario> listarClientes();
    Usuario obtenerPorCorreo(String username);  
}

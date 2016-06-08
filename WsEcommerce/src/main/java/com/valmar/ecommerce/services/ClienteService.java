package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Cliente;

public interface ClienteService {	

	Cliente obtenerPorId(int id);	 
    void agregar(Cliente nota);     
    void eliminar(int id);    
    List<Cliente> listarClientes();
    
}

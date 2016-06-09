package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Cliente;

public interface ClienteDao {

	Cliente obtenerPorId(int id);	 
    void agregar(Cliente cliente);     
    void eliminar(int id);    
    List<Cliente> listarClientes();
}

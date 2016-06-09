package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Tienda;

public interface TiendaService {
	Tienda obtenerPorId(int id);	 
    void agregar(Tienda tienda);     
    void eliminar(int id);    
    List<Tienda> listarTiendas();
}

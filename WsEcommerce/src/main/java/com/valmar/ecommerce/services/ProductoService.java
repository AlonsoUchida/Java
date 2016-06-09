package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Producto;

public interface ProductoService {
	Producto obtenerPorId(int id);	 
    void agregar(Producto producto);     
    void eliminar(int id);    
    List<Producto> listarProductos();
}

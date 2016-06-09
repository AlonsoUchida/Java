package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Producto;

public interface ProductoDao {
	Producto obtenerPorId(int id);	 
    void agregar(Producto producto);     
    void eliminar(int id);    
    List<Producto> listarProductos();
}

package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Producto;

public interface ProductoDao {
	Producto obtenerPorId(int id);
	Producto obtenerPorNombre(String nombre);	
    void agregar(Producto producto);    
    void actualizar(Producto producto); 
    void eliminar(int id);    
    List<Producto> listarProductos();
	List<Producto> obtenerProductosPorTienda(int id);     
}

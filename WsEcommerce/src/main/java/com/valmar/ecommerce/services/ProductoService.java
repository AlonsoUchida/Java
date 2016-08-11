package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Categoria;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.ImagenProducto;
import com.valmar.ecommerce.model.Marca;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;

public interface ProductoService {	
	Producto obtenerPorId(int id);	 
	Producto obtenerPorNombre(String nombre);
    void agregar(Producto producto);  
    void actualizar(Producto producto); 
    void eliminar(int id);    
    List<Producto> listarProductos();
       
    Marca obtenerMarcaPorId(int id);    
    Tienda obtenerTiendaPorId(int id);  
    Categoria obtenerCategoriaPorId(int id);
	List<Producto> obtenerProductosPorTienda(int id);
	ImagenProducto obtenerImagenPorDefecto(int id);
	
	Usuario obtenerUsuario(int id_usuario);
	Direccion obtenerDireccion(int id_direccion);
	List<Distrito> obtenerDitritosPorProvincia(int id);
	List<Direccion> obtenerDireccionesTiendasPorDistrito(int id);
	Tienda obtenerTiendaPorDireccion(int id);   
}

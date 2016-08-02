package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Envio;
import com.valmar.ecommerce.model.MetodoPago;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;

public interface TiendaService {
	Tienda obtenerPorId(int id);	 
    int agregar(Tienda tienda); 
    void actulizar(Tienda tiendaBean);
    void eliminar(int id);    
    List<Tienda> listarTiendas();
	Usuario obtenerUsuario(int id_usuario);
	MetodoPago obtenerMetodoPago(int id_metodoPago);
	Envio obtenerEnvio(int id_envio);
	List<Tienda> obtenerTiendasPorNombre(String nombre);
	List<Tienda> listarPorDistrito(int id);
	List<Tienda> obtenerTiendasPorNombreDistrito(String nombre, int id);
	List<Tienda> listarPorVendedor(int id);
	Tienda obtenerTiendaPorDireccion(int id);
	List<Tienda> obtenerTiendasPorNombreDistritoUrbanizacion(String nombre, int id, int id_urbanizacion);
	List<Tienda> listarPorBodeguero(int id);	
}

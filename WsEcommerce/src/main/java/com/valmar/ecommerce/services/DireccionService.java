package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Direccion;

public interface DireccionService {
	Direccion obtenerPorId(int id);	 
    void agregar(Direccion nota);     
    void eliminar(int id);    
    List<Direccion> listarDirecciones();
}

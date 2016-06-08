package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Direccion;

public interface DireccionDao {
	Direccion obtenerPorId(int id);	 
    void agregar(Direccion nota);     
    void eliminar(int id);    
    List<Direccion> listarDirecciones();
}

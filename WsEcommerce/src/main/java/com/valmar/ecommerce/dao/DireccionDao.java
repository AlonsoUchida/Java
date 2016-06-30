package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;

public interface DireccionDao {
	Direccion obtenerPorId(int id);	 
    void agregar(Direccion direccion);
    void actualizar(Direccion direccion);
    void eliminar(int id);    
    List<Direccion> listarDirecciones();	
    List<Direccion> obtenerDireccionesTiendasPorDistrito(int id);
}

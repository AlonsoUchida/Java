package com.valmar.ecommerce.dao;

import java.util.List;

import com.valmar.ecommerce.model.Contacto;

public interface ContactoDao {

	Contacto obtenerPorId(int id);	 
    void agregar(Contacto contacto); 
    void actualizar(Contacto contacto);
    void eliminar(int id);    
    List<Contacto> listarContactos();
    
}

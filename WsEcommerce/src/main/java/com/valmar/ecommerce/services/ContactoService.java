package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Contacto;

public interface ContactoService {
	
	Contacto obtenerPorId(int id);	 
    void agregar(Contacto contacto); 
    void actualizar(Contacto contacto);
    void eliminar(int id);    
    List<Contacto> listarContactos();
}

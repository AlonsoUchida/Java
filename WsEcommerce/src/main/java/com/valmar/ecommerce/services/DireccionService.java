package com.valmar.ecommerce.services;

import java.util.List;

import com.valmar.ecommerce.model.Departamento;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.model.Usuario;

public interface DireccionService {
	Direccion obtenerPorId(int id);	 
	Provincia obtenerProvinciaPorId(int id);
	Departamento obtenerDepartamentoPorId(int id);
	Distrito obtenerDistritoPorId(int id);
	Usuario obtenerUsuarioPorId(int id);
    void agregar(Direccion direccion); 
    void actualizar(Direccion direccion);  
    void eliminar(int id);    
    List<Direccion> listarDirecciones();
}

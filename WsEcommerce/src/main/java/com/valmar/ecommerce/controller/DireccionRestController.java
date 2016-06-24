package com.valmar.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.valmar.ecommerce.enums.DireccionActiva;
import com.valmar.ecommerce.model.Departamento;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.DireccionService;
import com.valmar.ecommerce.viewmodel.DireccionVM;

@CrossOrigin
@RestController
@RequestMapping("/direccion")
public class DireccionRestController {

	@Autowired
    DireccionService service;

    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Direccion>> listarDirecciones() {
        List<Direccion> direcciones = service.listarDirecciones();
        if(direcciones.isEmpty()){
            return new ResponseEntity<List<Direccion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Direccion>>(direcciones, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId", params= {"id"}, 
    		method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Direccion> obtenerPorId(@RequestParam("id") Integer id) {
    	Direccion direccion = service.obtenerPorId(id);
        if (direccion == null) {
            return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Direccion>(direccion, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody DireccionVM direccion,  UriComponentsBuilder ucBuilder) {
    	
    	Direccion direccionBean = new Direccion();
    	Departamento departamento = service.obtenerDepartamentoPorId(direccion.getId_departamento());
    	Provincia provincia = service.obtenerProvinciaPorId(direccion.getId_provincia());
    	Distrito distrito = service.obtenerDistritoPorId(direccion.getId_distrito());
    	Usuario usuario = service.obtenerUsuarioPorId(direccion.getId_usuario());
    	
    	if((departamento==null) && (provincia==null) && (distrito==null) && (usuario==null)){
    		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    	}
    	
    	List<Usuario> usuarios = new ArrayList<>();
    	usuarios.add(usuario);
    	
    	direccionBean.setUsuarios(usuarios);
    	direccionBean.setDepartamento(departamento);
    	direccionBean.setProvincia(provincia);
    	direccionBean.setDistrito(distrito);
    	direccionBean.setReferencia(direccion.getReferencia());
    	direccionBean.setDomicilio(direccion.getDomicilio());
    	direccionBean.setNumero(direccion.getNumero());
    	direccionBean.setLatitud(direccion.getLatitud());
    	direccionBean.setLongitud(direccion.getLongitud());
    	direccionBean.setActivo(DireccionActiva.NO_ACTIVA.getValue());
    	
        service.agregar(direccionBean); 
        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
    public ResponseEntity<Direccion> eliminar(@PathVariable("id") int id) {
    	Direccion direccion = service.obtenerPorId(id);
        if (direccion == null) {
            return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
        } 
        service.eliminar(id);
        return new ResponseEntity<Direccion>(HttpStatus.NO_CONTENT);
    }
}

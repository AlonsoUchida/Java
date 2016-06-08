package com.valmar.ecommerce.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.services.DireccionService;

@CrossOrigin
@RestController
@RequestMapping("/direccion")
public class DireccionRestController {

	@Autowired
    DireccionService service;
    /*
     * This method will list all existing audios.
     */
    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Direccion>> listarDirecciones() {
        List<Direccion> direcciones = service.listarDirecciones();
        if(direcciones.isEmpty()){
            return new ResponseEntity<List<Direccion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Direccion>>(direcciones, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Direccion> obtenerPorId(@PathVariable("id") int id) {
    	Direccion direccion = service.obtenerPorId(id);
        if (direccion == null) {
            return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Direccion>(direccion, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar/", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody Direccion direccion,  UriComponentsBuilder ucBuilder) {
    	int id = Integer.parseInt(direccion.getId().toString());
        if (service.obtenerPorId(id)!=null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } 
        service.agregar(direccion); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/direccion/{id}").buildAndExpand(direccion.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Direccion> eliminar(@PathVariable("id") int id) {
    	Direccion direccion = service.obtenerPorId(id);
        if (direccion == null) {
            return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
        } 
        service.eliminar(id);
        return new ResponseEntity<Direccion>(HttpStatus.NO_CONTENT);
    }
}

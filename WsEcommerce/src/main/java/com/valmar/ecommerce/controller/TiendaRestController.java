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

import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.services.TiendaService;

@CrossOrigin
@RestController
@RequestMapping("/tienda")
public class TiendaRestController {
	
	@Autowired
    TiendaService service;
    /*
     * This method will list all existing audios.
     */
    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Tienda>> listarTiendas() {
        List<Tienda> tiendas = service.listarTiendas();
        if(tiendas.isEmpty()){
            return new ResponseEntity<List<Tienda>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Tienda>>(tiendas, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tienda> obtenerPorId(@PathVariable("id") int id) {
    	Tienda tienda = service.obtenerPorId(id);
        if (tienda == null) {
            return new ResponseEntity<Tienda>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Tienda>(tienda, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar/", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody Tienda tienda,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorId(tienda.getId())!=null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } 
        service.agregar(tienda); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/tienda/{id}").buildAndExpand(tienda.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tienda> eliminar(@PathVariable("id") int id) {
    	Tienda tienda = service.obtenerPorId(id);
        if (tienda == null) {
            return new ResponseEntity<Tienda>(HttpStatus.NOT_FOUND);
        } 
        service.eliminar(id);
        return new ResponseEntity<Tienda>(HttpStatus.NO_CONTENT);
    }

}

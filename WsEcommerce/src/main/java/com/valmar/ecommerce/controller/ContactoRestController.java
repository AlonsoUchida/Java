package com.valmar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.valmar.ecommerce.model.Contacto;
import com.valmar.ecommerce.services.ContactoService;

@CrossOrigin
@RestController
@RequestMapping("/contacto")
public class ContactoRestController {

	@Autowired
    ContactoService service;
    /*
     * This method will list all existing audios.
     */
    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Contacto>> listarContactos() {
        List<Contacto> contactos = service.listarContactos();
        if(contactos.isEmpty()){
            return new ResponseEntity<List<Contacto>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Contacto>>(contactos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId", params= {"id"}, 
    		method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contacto> obtenerPorId(@RequestParam("id") Integer id) {
    	Contacto contacto = service.obtenerPorId(id);
        if (contacto == null) {
            return new ResponseEntity<Contacto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody Contacto contacto,  UriComponentsBuilder ucBuilder) {

        service.agregar(contacto); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contacto/{correo}").buildAndExpand(contacto.getCorreo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Contacto contacto,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorId(contacto.getId())==null) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } 
        
        service.actualizar(contacto); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contacto/{correo}").buildAndExpand(contacto.getCorreo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar",  params= {"id"}, method = RequestMethod.DELETE)
    public ResponseEntity<Contacto> eliminar(@RequestParam("id")int id) {
    	Contacto contacto = service.obtenerPorId(id);
        if (contacto == null) {
            return new ResponseEntity<Contacto>(HttpStatus.NO_CONTENT);
        } 
        service.eliminar(id);
        return new ResponseEntity<Contacto>(HttpStatus.NO_CONTENT);
    }
    
}

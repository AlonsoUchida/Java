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

import com.valmar.ecommerce.model.Cliente;
import com.valmar.ecommerce.services.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

	@Autowired
    ClienteService service;
    /*
     * This method will list all existing audios.
     */
    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = service.listarClientes();
        if(clientes.isEmpty()){
            return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable("id") int id) {
    	Cliente cliente = service.obtenerPorId(id);
        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar/", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody Cliente cliente,  UriComponentsBuilder ucBuilder) {
    	int id = Integer.parseInt(cliente.getId().toString());
        if (service.obtenerPorId(id)!=null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } 
        service.agregar(cliente); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> eliminar(@PathVariable("id") int id) {
    	Cliente cliente = service.obtenerPorId(id);
        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        } 
        service.eliminar(id);
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
    }

}

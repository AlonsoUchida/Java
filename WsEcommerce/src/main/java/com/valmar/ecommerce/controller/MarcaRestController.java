package com.valmar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valmar.ecommerce.model.Marca;
import com.valmar.ecommerce.services.MarcaService;

@CrossOrigin
@RestController
@RequestMapping("/marca")
public class MarcaRestController {

	@Autowired
	MarcaService service;
	
	@RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Marca>> listarMarcas() {
        List<Marca> marcas = service.listarMarcas();
        if(marcas.isEmpty()){
            return new ResponseEntity<List<Marca>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Marca>>(marcas, HttpStatus.OK);
    }
}

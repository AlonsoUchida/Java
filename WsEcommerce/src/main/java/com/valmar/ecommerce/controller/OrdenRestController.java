package com.valmar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valmar.ecommerce.model.Orden;
import com.valmar.ecommerce.services.OrdenService;

@CrossOrigin
@RestController
@RequestMapping("/orden")
public class OrdenRestController {

	@Autowired
    OrdenService service;	

    @RequestMapping(value = { "/listarPorUsuario" }, params = {"id"}, method = RequestMethod.GET)
    public ResponseEntity<List<Orden>> listarOrdenes(@RequestParam int id) {
        List<Orden> ordenes = service.listarOrdenes(id);
        if(ordenes.isEmpty()){
            return new ResponseEntity<List<Orden>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orden>>(ordenes, HttpStatus.OK);
    }
}

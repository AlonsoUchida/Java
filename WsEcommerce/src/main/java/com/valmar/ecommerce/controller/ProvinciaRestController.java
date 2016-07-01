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

import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.services.ProvinciaService;

@CrossOrigin
@RestController
@RequestMapping("/provincia")
public class ProvinciaRestController {

	@Autowired
    ProvinciaService service;

    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Provincia>> listarProvincias() {
        List<Provincia> provincias = service.listarProvincias();
        if(provincias.isEmpty()){
            return new ResponseEntity<List<Provincia>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Provincia>>(provincias, HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/listarPorDepartamento" }, params = {"id"}, method = RequestMethod.GET)
    public ResponseEntity<List<Provincia>> listarPorDepartamento(@RequestParam int id) {
        List<Provincia> provincias = service.listarPorDepartamento(id);
        if(provincias.isEmpty()){
            return new ResponseEntity<List<Provincia>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Provincia>>(provincias, HttpStatus.OK);
    }
}

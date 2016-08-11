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

import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.ClienteService;
import com.valmar.ecommerce.services.DistritoService;

@CrossOrigin
@RestController
@RequestMapping("/distrito")
public class DistritoRestController {

	@Autowired
	DistritoService service;

    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Distrito>> listarDistritos() {
        List<Distrito> distritos = service.listarDistritos();
        if(distritos.isEmpty()){
            return new ResponseEntity<List<Distrito>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Distrito>>(distritos, HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/listarPorProvincia" }, params = {"id"}, method = RequestMethod.GET)
    public ResponseEntity<List<Distrito>> listarPorProvincia(@RequestParam int id) {
    	List<Distrito> distritos = service.listarPorProvincia(id);
        if(distritos.isEmpty()){
            return new ResponseEntity<List<Distrito>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Distrito>>(distritos, HttpStatus.OK);
    }
}

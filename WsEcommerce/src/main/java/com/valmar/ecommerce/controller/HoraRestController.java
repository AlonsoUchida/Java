package com.valmar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valmar.ecommerce.model.Horas;
import com.valmar.ecommerce.services.HoraService;

@CrossOrigin
@RestController
@RequestMapping("/hora")
public class HoraRestController {

	@Autowired
	HoraService service;
	
	@RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Horas>> listar() {
        List<Horas> horas = service.listar();
        if(horas.isEmpty()){
            return new ResponseEntity<List<Horas>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Horas>>(horas, HttpStatus.OK);
    }
	
}

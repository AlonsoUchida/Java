package com.valmar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valmar.ecommerce.model.Dias;
import com.valmar.ecommerce.services.DiaService;

@CrossOrigin
@RestController
@RequestMapping("/dia")
public class DiaRestController {

	@Autowired
	DiaService service;
	
	@RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Dias>> listar() {
        List<Dias> dias = service.listar();
        if(dias.isEmpty()){
            return new ResponseEntity<List<Dias>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Dias>>(dias, HttpStatus.OK);
    }
}

package com.valmar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valmar.ecommerce.model.Banco;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.BancoService;

@CrossOrigin
@RestController
@RequestMapping("/banco")
public class BancoRestController {
	
	@Autowired
	BancoService service;
	
	@RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Banco>> listarBancos() {
        List<Banco> bancos = service.listarBancos();
        if(bancos.isEmpty()){
            return new ResponseEntity<List<Banco>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Banco>>(bancos, HttpStatus.OK);
    }

}

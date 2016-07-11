package com.valmar.ecommerce.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.valmar.ecommerce.model.Envio;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.services.EnvioService;
import com.valmar.ecommerce.services.TiendaService;
import com.valmar.ecommerce.viewmodel.EnvioVM;

@CrossOrigin
@RestController
@RequestMapping("/envio")
public class EnvioRestController {

	@Autowired
	EnvioService service;
	@Autowired
	TiendaService tiendaService;
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody EnvioVM envio,  UriComponentsBuilder ucBuilder) {
		Envio envioBean = new Envio();
		envioBean.setNombre(envio.getNombre());
		envioBean.setValor(envio.getValor());
		Tienda tienda = tiendaService.obtenerPorId(envio.getId_tienda());
		if(tienda==null){
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		List<Tienda> tiendas = new ArrayList<>();
		tiendas.add(tienda);
		envioBean.setTiendas(new HashSet(tiendas));
		
		service.agregar(envioBean);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/envio/{nombre}").buildAndExpand(envio.getNombre()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}

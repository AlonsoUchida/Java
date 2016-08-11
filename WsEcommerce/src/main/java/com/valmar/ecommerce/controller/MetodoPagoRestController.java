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

import com.valmar.ecommerce.enums.TipoEstado;
import com.valmar.ecommerce.model.MetodoPago;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.MetodoPagoService;
import com.valmar.ecommerce.services.TiendaService;
import com.valmar.ecommerce.viewmodel.MetodoPagoVM;


@CrossOrigin
@RestController
@RequestMapping("/metodoPago")
public class MetodoPagoRestController {

	@Autowired
	MetodoPagoService service;
	@Autowired
	TiendaService tiendaService;
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody MetodoPagoVM metodoPago,  UriComponentsBuilder ucBuilder) {
		MetodoPago metodoPagoBean = new MetodoPago();
		metodoPagoBean.setNombre(metodoPago.getNombre());
		metodoPagoBean.setEstado(TipoEstado.HABILITADO.getValue());
		Tienda tienda = tiendaService.obtenerPorId(metodoPago.getId_tienda());
		if(tienda==null){
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		List<Tienda> tiendas = new ArrayList<>();
		tiendas.add(tienda);
		metodoPagoBean.setTiendas(new HashSet(tiendas));
        service.agregar(metodoPagoBean); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/metodoPago/{nombre}").buildAndExpand(metodoPago.getNombre()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
}

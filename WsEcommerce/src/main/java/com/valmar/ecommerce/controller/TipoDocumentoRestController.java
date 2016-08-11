package com.valmar.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.TipoDocumento;
import com.valmar.ecommerce.services.DistritoService;
import com.valmar.ecommerce.services.TipoDocumentoService;

@CrossOrigin
@RestController
@RequestMapping("/tipodocumento")
public class TipoDocumentoRestController {

	@Autowired
	TipoDocumentoService service;
	
	@RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
	public ResponseEntity<List<TipoDocumento>> listar() {
		List<TipoDocumento> tipoDocumentos = service.listar();
		if (tipoDocumentos.isEmpty()) {
			return new ResponseEntity<List<TipoDocumento>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TipoDocumento>>(tipoDocumentos, HttpStatus.OK);
	}
}

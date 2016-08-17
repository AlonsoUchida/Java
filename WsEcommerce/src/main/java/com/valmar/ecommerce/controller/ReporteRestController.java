package com.valmar.ecommerce.controller;

import java.util.Date;
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

import com.valmar.ecommerce.model.ReporteDiario;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.ReporteDiarioService;
import com.valmar.ecommerce.services.TiendaService;
import com.valmar.ecommerce.services.UsuarioService;
import com.valmar.ecommerce.viewmodel.ReporteDiarioVM;
import com.valmar.ecommerce.viewmodel.ReporteVM;

@CrossOrigin
@RestController
@RequestMapping("/reporte")
public class ReporteRestController {

	@Autowired
	ReporteDiarioService diarioService;
	@Autowired
	UsuarioService usuarioService;	
	@Autowired
	TiendaService tiendaService;
	
	@RequestMapping(value = { "/listarReporteRegistrosPorVendedor" }, method = RequestMethod.GET)
	public ResponseEntity<List<ReporteVM>> listarReporteRegistrosPorVendedor(int id) {
		List<ReporteVM> items = usuarioService.obtenerReporteRegistrosPorVendedor(id);
		if (items.isEmpty()) {
			return new ResponseEntity<List<ReporteVM>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ReporteVM>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = { "/listarReportes" }, method = RequestMethod.GET)
	public ResponseEntity<List<ReporteDiario>> listarReportesDiario() {
		List<ReporteDiario> items = diarioService.listar();
		if (items.isEmpty()) {
			return new ResponseEntity<List<ReporteDiario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ReporteDiario>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = { "/agregarReporte" }, method = RequestMethod.POST)
	public ResponseEntity<Void> agregarReporte(@RequestBody ReporteDiarioVM reporteDiarioVM,
			UriComponentsBuilder ucBuilder) {

		ReporteDiario bean = new ReporteDiario();
		if(reporteDiarioVM.getId_tienda()!=null){
			Tienda tienda = tiendaService.obtenerPorId(reporteDiarioVM.getId_tienda());		
			bean.setTienda(tienda);
		}
		Usuario usuario = usuarioService.obtenerPorId(reporteDiarioVM.getId_usuario());
		
		if(usuario==null){
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		bean.setId(reporteDiarioVM.getId());
		bean.setUsuario(usuario);
		bean.setLatitud(reporteDiarioVM.getLatitud());
		bean.setLongitud(reporteDiarioVM.getLongitud());
		bean.setNombre(reporteDiarioVM.getNombre());
		bean.setObservacion(reporteDiarioVM.getObservacion());
		bean.setFecha(new Date());
		
		diarioService.agregar(bean);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				ucBuilder.path("/reporteDiario/{nombre}").buildAndExpand(reporteDiarioVM.getNombre()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}

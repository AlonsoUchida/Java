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

import com.valmar.ecommerce.model.Departamento;
import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.services.DepartamentoService;

@CrossOrigin
@RestController
@RequestMapping("/departamento")
public class DepartamentoRestController {

	@Autowired
    DepartamentoService service;
    /*
     * This method will list all existing audios.
     */
    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        List<Departamento> departamentos = service.listarDepartamentos();
        if(departamentos.isEmpty()){
            return new ResponseEntity<List<Departamento>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Departamento>>(departamentos, HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/obtenerDepartamentoPorProvincia" }, params = {"id"}, method = RequestMethod.GET)
    public ResponseEntity<Departamento> obtenerDepartamentoPorProvincia(@RequestParam int id) {
    	Departamento departamento = service.obtenerDepartamentoPorProvincia(id);
        if(departamento==null){
            return new ResponseEntity<Departamento>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
    }
}

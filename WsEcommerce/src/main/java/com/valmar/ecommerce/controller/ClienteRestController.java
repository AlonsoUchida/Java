package com.valmar.ecommerce.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.valmar.ecommerce.enums.TipoEstado;
import com.valmar.ecommerce.enums.TipoUsuario;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.TipoDocumento;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.ClienteService;
import com.valmar.ecommerce.services.DistritoService;
import com.valmar.ecommerce.services.TipoDocumentoService;
import com.valmar.ecommerce.util.DateUtil;
import com.valmar.ecommerce.util.EncryptUtil;
import com.valmar.ecommerce.viewmodel.ClienteVM;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

	@Autowired
    ClienteService service;
	
	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
	@Autowired
	DistritoService distritoService;

    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listarClientes() {
        List<Usuario> clientes = service.listarClientes();
        if(clientes.isEmpty()){
            return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Usuario>>(clientes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId", params= {"id"}, 
    		method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> obtenerPorId(@RequestParam("id") Integer id) {
    	Usuario cliente = service.obtenerPorId(id);
        if (cliente == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Usuario>(cliente, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody ClienteVM cliente,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorCorreo(cliente.getCorreo())!=null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } 
        Usuario clienteBean = new Usuario();
        clienteBean.setNombre(cliente.getNombre());
        clienteBean.setApellido(cliente.getApellido());
        clienteBean.setCorreo(cliente.getCorreo());
        clienteBean.setPassword(EncryptUtil.encriptar(cliente.getPassword()));
        clienteBean.setGenero(cliente.getGenero());
        clienteBean.setTipo(TipoUsuario.CLIENTE.getValue());
        TipoDocumento tipoDocumento = tipoDocumentoService.obtenerPorId(cliente.getId_tipoDocumento());
        if(tipoDocumento!=null)
        	clienteBean.setTipoDocumento(tipoDocumento);
        clienteBean.setValorDocumento(cliente.getValorDocumento());
        clienteBean.setTelefonoLocal(cliente.getTelefonoLocal());
        clienteBean.setTelefonoMovil(cliente.getTelefonoMovil());
        Distrito distrito  = distritoService.obtenerPorId(cliente.getId_distrito());
        if(distrito!=null)
        	clienteBean.setDistrito(distrito);
        clienteBean.setDireccionFiscal(cliente.getDireccionFiscal());     
        Date fechaNacimiento = DateUtil.getDateFromString(cliente.getFechaNacimiento());
        clienteBean.setFechaNacimiento(fechaNacimiento);
        clienteBean.setEstado(TipoEstado.HABILITADO.getValue());
        clienteBean.setFechaRegistro(new Date());
        clienteBean.setFechaModificacion(new Date());
        
        service.agregar(clienteBean); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cliente/{correo}").buildAndExpand(cliente.getCorreo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody ClienteVM cliente,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorId(cliente.getId())==null) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } 
        Usuario clienteBean = new Usuario();
        clienteBean.setId(cliente.getId());
        clienteBean.setNombre(cliente.getNombre());
        clienteBean.setApellido(cliente.getApellido());
        clienteBean.setCorreo(cliente.getCorreo());
        clienteBean.setPassword(EncryptUtil.encriptar(cliente.getPassword()));
        clienteBean.setGenero(cliente.getGenero());
        clienteBean.setTipo(TipoUsuario.CLIENTE.getValue());
        TipoDocumento tipoDocumento = tipoDocumentoService.obtenerPorId(cliente.getId_tipoDocumento());
        if(tipoDocumento!=null)
        	clienteBean.setTipoDocumento(tipoDocumento);
        clienteBean.setValorDocumento(cliente.getValorDocumento());
        clienteBean.setTelefonoLocal(cliente.getTelefonoLocal());
        clienteBean.setTelefonoMovil(cliente.getTelefonoMovil());
        Distrito distrito  = distritoService.obtenerPorId(cliente.getId_distrito());
        if(distrito!=null)
        	clienteBean.setDistrito(distrito);
        clienteBean.setDireccionFiscal(cliente.getDireccionFiscal());     
        Date fechaNacimiento = DateUtil.getDateFromString(cliente.getFechaNacimiento());
        clienteBean.setFechaNacimiento(fechaNacimiento);
        clienteBean.setEstado(TipoEstado.HABILITADO.getValue());
        clienteBean.setFechaRegistro(new Date());
        clienteBean.setFechaModificacion(new Date());
        
        service.actualizar(clienteBean); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cliente/{correo}").buildAndExpand(cliente.getCorreo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar",  params= {"id"}, method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> eliminar(@RequestParam("id")int id) {
    	Usuario cliente = service.obtenerPorId(id);
        if (cliente == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        } 
        service.eliminar(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }

}

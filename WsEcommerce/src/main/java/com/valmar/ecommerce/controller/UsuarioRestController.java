package com.valmar.ecommerce.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.valmar.ecommerce.enums.TipoEstado;
import com.valmar.ecommerce.enums.TipoUsuario;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.TipoDocumento;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.DireccionService;
import com.valmar.ecommerce.services.TipoDocumentoService;
import com.valmar.ecommerce.services.UsuarioService;
import com.valmar.ecommerce.util.DateUtil;
import com.valmar.ecommerce.util.EncryptUtil;
import com.valmar.ecommerce.viewmodel.BodegueroVM;
import com.valmar.ecommerce.viewmodel.ClienteVM;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = service.listarUsuarios();
        if(usuarios.isEmpty()){
            return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/listarPorVendedor" }, method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listarUsuariosPorVendedor(@RequestParam("id") int id) {
        List<Usuario> usuarios = service.listarUsuariosPorVendedor(id);
        if(usuarios.isEmpty()){
            return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId", params={"id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> obtenerPorId(@RequestParam("id") int id) {
    	Usuario usuario = service.obtenerPorId(id);
        if (usuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody BodegueroVM bodeguero,  UriComponentsBuilder ucBuilder) {
    	 if (service.obtenerPorCorreo(bodeguero.getCorreo())!=null) {
             return new ResponseEntity<Void>(HttpStatus.CONFLICT);
         } 
         Usuario clienteBean = new Usuario();
         clienteBean.setNombre(bodeguero.getNombre());
         clienteBean.setApellido(bodeguero.getApellido());
         clienteBean.setCorreo(bodeguero.getCorreo());
         clienteBean.setPassword(EncryptUtil.encriptar(bodeguero.getPassword()));
         clienteBean.setGenero(bodeguero.getGenero());
         TipoDocumento tipoDocumento = tipoDocumentoService.obtenerPorId(bodeguero.getId_tipoDocumento());
         if(tipoDocumento!=null)
         	clienteBean.setTipoDocumento(tipoDocumento);
         clienteBean.setValorDocumento(bodeguero.getValorDocumento());
         clienteBean.setDireccionFiscal(bodeguero.getDireccionFiscal());
         if(bodeguero.getFechaNacimiento()!=null && !bodeguero.getFechaNacimiento().isEmpty())
        	 clienteBean.setFechaNacimiento(DateUtil.getDateFromString(bodeguero.getFechaNacimiento()));
         //Para asociar el vendedor que lo registra
         Usuario vendedor = service.obtenerPorId(bodeguero.getId_vendedor());
         if(vendedor!=null)
        	 clienteBean.setUsuario(vendedor);
         
         clienteBean.setTipo(TipoUsuario.BODEGUERO.getValue());
         clienteBean.setEstado(TipoEstado.HABILITADO.getValue());
         clienteBean.setFechaRegistro(new Date());
         clienteBean.setFechaModificacion(new Date());
         
         service.agregar(clienteBean); 
         
         HttpHeaders headers = new HttpHeaders();
         headers.setLocation(ucBuilder.path("/bodeguero/{correo}").buildAndExpand(bodeguero.getCorreo()).toUri());
         return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody BodegueroVM bodeguero,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorId(bodeguero.getId())==null) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } 
        Usuario clienteBean = new Usuario();
        clienteBean.setId(bodeguero.getId());
        clienteBean.setNombre(bodeguero.getNombre());
        clienteBean.setApellido(bodeguero.getApellido());
        clienteBean.setCorreo(bodeguero.getCorreo());
        clienteBean.setPassword(EncryptUtil.encriptar(bodeguero.getPassword()));
        clienteBean.setGenero(bodeguero.getGenero());
        TipoDocumento tipoDocumento = tipoDocumentoService.obtenerPorId(bodeguero.getId_tipoDocumento());
        if(tipoDocumento!=null)
        	clienteBean.setTipoDocumento(tipoDocumento);
        clienteBean.setValorDocumento(bodeguero.getValorDocumento());
        clienteBean.setDireccionFiscal(bodeguero.getDireccionFiscal());
        if(bodeguero.getFechaNacimiento()!=null && !bodeguero.getFechaNacimiento().isEmpty())
       	 clienteBean.setFechaNacimiento(DateUtil.getDateFromString(bodeguero.getFechaNacimiento()));
        //Para asociar el vendedor que lo registra
        Usuario vendedor = service.obtenerPorId(bodeguero.getId_vendedor());
        if(vendedor!=null)
       	 clienteBean.setUsuario(vendedor);
        clienteBean.setTipo(TipoUsuario.BODEGUERO.getValue());
        clienteBean.setEstado(TipoEstado.HABILITADO.getValue());
        clienteBean.setFechaModificacion(new Date());
        
        service.actualizar(clienteBean); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bodeguero/{correo}").buildAndExpand(bodeguero.getCorreo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> eliminar(@RequestParam("id") int id) {
    	Usuario usuario = service.obtenerPorId(id);
        if (usuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        } 
        service.eliminar(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }

}

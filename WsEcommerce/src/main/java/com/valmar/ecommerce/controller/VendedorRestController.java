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
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.UsuarioService;
import com.valmar.ecommerce.viewmodel.BodegueroVM;

@CrossOrigin
@RestController
@RequestMapping("/vendedor")
public class VendedorRestController {

	@Autowired
	UsuarioService service;
    /*
     * This method will list all existing audios.
     */
    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listarVendedores() {
        List<Usuario> usuarios = service.listarVendedores();
        if(usuarios.isEmpty()){
            return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId", params={"id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> obtenerPorId(@RequestParam("id") int id) {
    	Usuario usuario = service.obtenerPorId(id);
        if (usuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
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
         clienteBean.setPassword(bodeguero.getPassword());
         clienteBean.setGenero(bodeguero.getGenero());
         clienteBean.setTipo(TipoUsuario.VENDEDOR.getValue());
         clienteBean.setEstado(TipoEstado.HABILITADO.getValue());
         clienteBean.setFechaRegistro(new Date());
         clienteBean.setFechaModificacion(new Date());
         
         service.agregar(clienteBean); 
         
         HttpHeaders headers = new HttpHeaders();
         headers.setLocation(ucBuilder.path("/vendedor/{correo}").buildAndExpand(bodeguero.getCorreo()).toUri());
         return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody BodegueroVM bodeguero,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorId(bodeguero.getId())==null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } 
        Usuario clienteBean = new Usuario();
        clienteBean.setId(bodeguero.getId());
        clienteBean.setNombre(bodeguero.getNombre());
        clienteBean.setApellido(bodeguero.getApellido());
        clienteBean.setCorreo(bodeguero.getCorreo());
        clienteBean.setPassword(bodeguero.getPassword());
        clienteBean.setGenero(bodeguero.getGenero());
        clienteBean.setTipo(TipoUsuario.VENDEDOR.getValue());
        clienteBean.setEstado(TipoEstado.HABILITADO.getValue());
        clienteBean.setFechaModificacion(new Date());
        
        service.actualizar(clienteBean); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/vendedor/{correo}").buildAndExpand(bodeguero.getCorreo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> eliminar(@RequestParam("id") int id) {
    	Usuario usuario = service.obtenerPorId(id);
        if (usuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        } 
        service.eliminar(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }
    
}

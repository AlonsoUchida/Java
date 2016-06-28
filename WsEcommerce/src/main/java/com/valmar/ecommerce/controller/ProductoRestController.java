package com.valmar.ecommerce.controller;

import java.util.ArrayList;
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
import com.valmar.ecommerce.model.Categoria;
import com.valmar.ecommerce.model.Marca;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.services.ProductoService;
import com.valmar.ecommerce.viewmodel.ProductoVM;

@CrossOrigin
@RestController
@RequestMapping("/producto")
public class ProductoRestController {
	
	@Autowired
    ProductoService service;

    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = service.listarProductos();
        if(productos.isEmpty()){
            return new ResponseEntity<List<Producto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/obtenerPorId", params = {"id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> obtenerPorId(@RequestParam("id") int id) {
    	Producto producto = service.obtenerPorId(id);
        if (producto == null) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody ProductoVM producto,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorNombre(producto.getNombre())!=null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } 
        
        Marca marca = service.obtenerMarcaPorId(producto.getId_marca());
        Categoria categoria = service.obtenerCategoriaPorId(producto.getId_categoria());
        Tienda tienda = service.obtenerTiendaPorId(producto.getId_tienda());
        
        if((marca==null) || (categoria==null) || (tienda==null)){
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
        Producto productoBean = new Producto();        
        productoBean.setNombre(producto.getNombre());
        productoBean.setDescripcion(producto.getDescripcion());
        productoBean.setCaracteristicas(producto.getCaracteristicas());
        productoBean.setPrecio(producto.getPrecio());
        productoBean.setPresentacion(producto.getPresentacion());
        productoBean.setDescuento(producto.getDescuento());
        productoBean.setEstado(TipoEstado.HABILITADO.getValue());
        productoBean.setFechaRegistro(new Date());
        productoBean.setFechaModificacion(new Date());    
        productoBean.setMarca(marca);
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(categoria);
        productoBean.setCategorias(categorias);
        productoBean.setTienda(tienda);
        
        service.agregar(productoBean); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producto/{nombre}").buildAndExpand(producto.getNombre()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody ProductoVM producto,  UriComponentsBuilder ucBuilder) {
    	
    	Producto _producto = service.obtenerPorId(producto.getId());
        Marca marca = service.obtenerMarcaPorId(producto.getId_marca());
        Categoria categoria = service.obtenerCategoriaPorId(producto.getId_categoria());
        Tienda tienda = service.obtenerTiendaPorId(producto.getId_tienda());
        
        if((marca==null) || (categoria==null) || (tienda==null) || (_producto==null)){
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
        Producto productoBean = new Producto();  
        productoBean.setId(producto.getId());
        productoBean.setNombre(producto.getNombre());
        productoBean.setDescripcion(producto.getDescripcion());
        productoBean.setCaracteristicas(producto.getCaracteristicas());
        productoBean.setPrecio(producto.getPrecio());
        productoBean.setPresentacion(producto.getPresentacion());
        productoBean.setDescuento(producto.getDescuento());
        productoBean.setEstado(TipoEstado.HABILITADO.getValue());
        productoBean.setFechaModificacion(new Date()); 
        productoBean.setMarca(marca);
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(categoria);
        productoBean.setCategorias(categorias);
        productoBean.setTienda(tienda);
        
        service.actualizar(productoBean); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producto/{nombre}").buildAndExpand(producto.getNombre()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eliminar", params = {"id"}, method = RequestMethod.DELETE)
    public ResponseEntity<Producto> eliminar(@RequestParam("id") int id) {
    	Producto producto = service.obtenerPorId(id);
        if (producto == null) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        } 
        service.eliminar(id);
        return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
    }

}

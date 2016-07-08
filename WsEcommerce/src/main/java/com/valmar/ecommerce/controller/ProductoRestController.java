package com.valmar.ecommerce.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import com.valmar.ecommerce.enums.TipoImagen;
import com.valmar.ecommerce.model.Categoria;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.ImagenProducto;
import com.valmar.ecommerce.model.Marca;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.ImagenProductoService;
import com.valmar.ecommerce.services.ProductoService;
import com.valmar.ecommerce.services.UsuarioService;
import com.valmar.ecommerce.util.DistanceCalculatorUtil;
import com.valmar.ecommerce.viewmodel.ImagenProductoVM;
import com.valmar.ecommerce.viewmodel.ProductoPorTiendaVM;
import com.valmar.ecommerce.viewmodel.ProductoVM;

@CrossOrigin
@RestController
@RequestMapping("/producto")
public class ProductoRestController {
	
	@Autowired
    ProductoService service;	
	@Autowired
	ImagenProductoService imagenProductoService;

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
            return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregar(@RequestBody ProductoVM producto,  UriComponentsBuilder ucBuilder) {
        if (service.obtenerPorNombre(producto.getNombre())!=null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } 
        
        Marca marca = service.obtenerMarcaPorId(producto.getId_marca());
        List<Categoria> categorias = new ArrayList<>();
        for(int indice : producto.getId_categoria()){
        	Categoria categoria = service.obtenerCategoriaPorId(indice);
        	categorias.add(categoria);
        }
        Tienda tienda = service.obtenerTiendaPorId(producto.getId_tienda());
        
        if((marca==null) || (categorias.isEmpty()) || (tienda==null)){
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
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
        List<Categoria> categorias = new ArrayList<>();
        for(int indice : producto.getId_categoria()){
        	Categoria categoria = service.obtenerCategoriaPorId(indice);
        	categorias.add(categoria);
        }
        
        Tienda tienda = service.obtenerTiendaPorId(producto.getId_tienda());
        
        if((marca==null) || (categorias.isEmpty()) || (tienda==null) || (_producto==null)){
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
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
            return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
        } 
        service.eliminar(id);
        return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
    }
    
    /************************************************************************************************/
    /******************************    Imagenes de Producto *****************************************/
    /************************************************************************************************/
    
    @RequestMapping(value = { "/imagen/listar" }, method = RequestMethod.GET)
    public ResponseEntity<List<ImagenProducto>> listarImagenes() {
        List<ImagenProducto> imagenes = imagenProductoService.listarImagenes();
        if(imagenes.isEmpty()){
            return new ResponseEntity<List<ImagenProducto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ImagenProducto>>(imagenes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/imagen/obtenerPorId", params = {"id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImagenProducto> obtenerImagenPorId(@RequestParam("id") int id) {
    	ImagenProducto imagen = imagenProductoService.obtenerImagenPorId(id);
        if (imagen == null) {
            return new ResponseEntity<ImagenProducto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ImagenProducto>(imagen, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/imagen/agregar", method = RequestMethod.POST)
    public ResponseEntity<Void> agregarImagen(@RequestBody ImagenProductoVM imagen,  UriComponentsBuilder ucBuilder) {
        ImagenProducto imagenBean = new ImagenProducto();
        Producto producto = service.obtenerPorId(imagen.getId_producto());
        
        if(producto==null){
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        
        imagenBean.setNombre(imagen.getNombre());
        imagenBean.setProducto(producto);
        imagenBean.setImagen(imagen.getImagen());
        imagenBean.setDefecto(TipoImagen.SECUNDARIO.getValue());
        
        imagenProductoService.agregarImagen(imagenBean);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/imagen/{nombre}").buildAndExpand(producto.getNombre()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    @RequestMapping(value = "/imagen/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizarImagen(@RequestBody ImagenProductoVM imagen,  UriComponentsBuilder ucBuilder) {
    	ImagenProducto imagenBean = new ImagenProducto();
        Producto producto = service.obtenerPorId(imagen.getId_producto());
        
        if(producto==null){
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        imagenBean.setId(imagen.getId());
        imagenBean.setNombre(imagen.getNombre());
        imagenBean.setProducto(producto);
        imagenBean.setImagen(imagen.getImagen());
        imagenBean.setDefecto(imagen.getId());
        
        imagenProductoService.actualizarImagen(imagenBean);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/imagen/{nombre}").buildAndExpand(producto.getNombre()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/imagen/eliminar", params = {"id"}, method = RequestMethod.DELETE)
    public ResponseEntity<ImagenProducto> eliminarImagen(@RequestParam("id") int id) {
    	ImagenProducto producto = imagenProductoService.obtenerImagenPorId(id);
        if (producto == null) {
            return new ResponseEntity<ImagenProducto>(HttpStatus.NO_CONTENT);
        } 
        imagenProductoService.eliminarImagen(id);;
        return new ResponseEntity<ImagenProducto>(HttpStatus.NO_CONTENT);
    }
    
    
    @RequestMapping(value = { "/imagen/listarImagenesPorProducto" }, method = RequestMethod.GET)
    public ResponseEntity<List<ImagenProducto>> listarImagenesPorProducto(int id) {
        List<ImagenProducto> imagenes = imagenProductoService.listarImagenesPorProducto(id);
        if(imagenes.isEmpty()){
            return new ResponseEntity<List<ImagenProducto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ImagenProducto>>(imagenes, HttpStatus.OK);
    }

    /************************************************************************************************/
    /******************************    Filtros por Tienda y por Radio de Cobertura ******************/
    /************************************************************************************************/
    @RequestMapping(value = "/obtenerPorTienda", params = {"id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoPorTiendaVM>> obtenerPorTienda(@RequestParam("id") int id) {
    	List<ProductoPorTiendaVM> _productos = obtenerProductosPorTienda(id);
    	if(_productos==null){
    		return new ResponseEntity<List<ProductoPorTiendaVM>>(HttpStatus.NO_CONTENT);
    	}   
        return new ResponseEntity<List<ProductoPorTiendaVM>>(_productos, HttpStatus.OK);
    }
    
    private List<ProductoPorTiendaVM> obtenerProductosPorTienda(int id){
    	Tienda tienda = service.obtenerTiendaPorId(id);
    	if (tienda==null){
    		return null;
    	}
    	List<Producto> productos = service.obtenerProductosPorTienda(id);
        if (productos.isEmpty()) {
            return null;
        }
        
        List<ProductoPorTiendaVM> _productos = new ArrayList<>();
        for(Producto item : productos){
        	ProductoPorTiendaVM _producto = new ProductoPorTiendaVM();
        	 ImagenProducto imagen = service.obtenerImagenPorDefecto(item.getId());
        	 if(imagen!=null){
        		 _producto.setImagen(imagen.getImagen());
        	 }
        	_producto.setId(item.getId());
        	_producto.setNombre(item.getNombre());
        	_producto.setDescripcion(item.getDescripcion());
        	_producto.setCaracteristicas(item.getCaracteristicas());
        	_producto.setPresentacion(item.getPresentacion());
        	_producto.setPrecio(item.getPrecio());
        	_producto.setCostoMinimo(tienda.getCostoMinimo());
        	_producto.setId_tienda(tienda.getId());
        	_producto.setDescuento(item.getDescuento());
        	
        	int[] idCategorias = new int[item.getCategorias().size()];
        	int count = 0;
        	for(Categoria cat : item.getCategorias()){
        		idCategorias[count] = cat.getId();
        		count++;
        	}
        	
        	_producto.setId_categoria(idCategorias);
        	
        	_productos.add(_producto);
        }
        return _productos;
       
    }
    
    @RequestMapping(value = "/obtenerPorDireccionDeUsuario", params = {"id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoPorTiendaVM>> obtenerPorDireccionDeUsuario(@RequestParam("id") int id) {


    	double radio = DistanceCalculatorUtil.RADIO_USUARIO; 
    	double costoMinimo = 0;
    	Direccion direccion = service.obtenerDireccion(id);
    	
    	if (direccion==null){
    		return new ResponseEntity<List<ProductoPorTiendaVM>>(HttpStatus.NO_CONTENT);
    	}
    	
    	double latitudCliente = Double.parseDouble(direccion.getLatitud());
    	double longitudCliente = Double.parseDouble(direccion.getLongitud());
    	
    	Distrito distrito = direccion.getDistrito();
    	List<Distrito> distritos = service.obtenerDitritosPorProvincia(distrito.getId());
    	List<Direccion> direcciones = new ArrayList<>();
    	List<ProductoPorTiendaVM> productosPorTienda = new ArrayList<>();
    	
    	for(Distrito item : distritos){
    		direcciones.addAll(service.obtenerDireccionesTiendasPorDistrito(item.getId()));
    	}	
    	for(Direccion item : direcciones){
    		double latitudTienda = Double.parseDouble(item.getLatitud());
    		double longitudTienda = Double.parseDouble(item.getLongitud());
    		double distancia = DistanceCalculatorUtil.distance(latitudCliente, longitudCliente, latitudTienda, longitudTienda, "K");
    		if(distancia<radio){
    			Tienda tienda = service.obtenerTiendaPorDireccion(item.getId());
    			List<ProductoPorTiendaVM> _productos = obtenerProductosPorTienda(tienda.getId());
    			productosPorTienda.addAll(_productos);
    		}
    		
    	}
        if (productosPorTienda.isEmpty()) {
            return new ResponseEntity<List<ProductoPorTiendaVM>>(HttpStatus.NO_CONTENT);
        }
              
        return new ResponseEntity<List<ProductoPorTiendaVM>>(productosPorTienda, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/obtenerPorCategoriaDireccionDeUsuario", params = {"id_categoria", "id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoPorTiendaVM>> obtenerPorCategoriaDireccionDeUsuario(@RequestParam("id_categoria") int id_categoria, @RequestParam("id") int id) {

    	double radio = DistanceCalculatorUtil.RADIO_USUARIO;
    	double costoMinimo = 0;
    	Direccion direccion = service.obtenerDireccion(id);
    	
    	if (direccion==null){
    		return new ResponseEntity<List<ProductoPorTiendaVM>>(HttpStatus.NO_CONTENT);
    	}
    	
    	double latitudCliente = Double.parseDouble(direccion.getLatitud());
    	double longitudCliente = Double.parseDouble(direccion.getLongitud());
    	
    	Distrito distrito = direccion.getDistrito();
    	List<Distrito> distritos = service.obtenerDitritosPorProvincia(distrito.getId());
    	List<Direccion> direcciones = new ArrayList<>();
    	List<ProductoPorTiendaVM> productosPorTienda = new ArrayList<>();
    	
    	for(Distrito item : distritos){
    		direcciones.addAll(service.obtenerDireccionesTiendasPorDistrito(item.getId()));
    	}	
    	for(Direccion item : direcciones){
    		double latitudTienda = Double.parseDouble(item.getLatitud());
    		double longitudTienda = Double.parseDouble(item.getLongitud());
    		double distancia = DistanceCalculatorUtil.distance(latitudCliente, longitudCliente, latitudTienda, longitudTienda, "K");
    		if(distancia<radio){
    			Tienda tienda = service.obtenerTiendaPorDireccion(item.getId());
    			List<ProductoPorTiendaVM> _productos = obtenerProductosPorTienda(tienda.getId());
    			List<ProductoPorTiendaVM> _productosFinal = new ArrayList<>();
    			for(ProductoPorTiendaVM prod : _productos){
    				for(int indice : prod.getId_categoria()){
    					if(indice==id_categoria){
    						_productosFinal.add(prod);
    					}
    				}
    			}
    			productosPorTienda.addAll(_productosFinal);
    		}
    		
    	}
        if (productosPorTienda.isEmpty()) {
            return new ResponseEntity<List<ProductoPorTiendaVM>>(HttpStatus.NO_CONTENT);
        }
              
        return new ResponseEntity<List<ProductoPorTiendaVM>>(productosPorTienda, HttpStatus.OK);
    }
}

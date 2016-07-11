package com.valmar.ecommerce.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.valmar.ecommerce.enums.TipoImagen;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.Envio;
import com.valmar.ecommerce.model.ImagenProducto;
import com.valmar.ecommerce.model.ImagenTienda;
import com.valmar.ecommerce.model.MetodoPago;
import com.valmar.ecommerce.model.Producto;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.DireccionService;
import com.valmar.ecommerce.services.ImagenTiendaService;
import com.valmar.ecommerce.services.TiendaService;
import com.valmar.ecommerce.util.DistanceCalculatorUtil;
import com.valmar.ecommerce.viewmodel.ImagenProductoVM;
import com.valmar.ecommerce.viewmodel.ProductoPorTiendaVM;
import com.valmar.ecommerce.viewmodel.TiendaVM;
import com.valmar.ecommerce.viewmodel.TiendaVMLite;

@CrossOrigin
@RestController
@RequestMapping("/tienda")
public class TiendaRestController {

	@Autowired
	TiendaService service;
	@Autowired
	DireccionService direccionService;
	@Autowired
	ImagenTiendaService imagenTiendaService;

	private List<TiendaVMLite> clonarTiendasVMLite(List<Tienda> tiendas) {
		List<TiendaVMLite> tiendasLite = new ArrayList<>();
		for (Tienda item : tiendas) {
			TiendaVMLite _tienda = new TiendaVMLite();
			_tienda.setId(item.getId());
			_tienda.setNombre(item.getNombre());
			_tienda.setHorarioAtencion(item.getHorarioAtencion());
			_tienda.setEstado(item.getEstado());
			_tienda.setTelefonoFijo(item.getTelefono_local());
			_tienda.setTelefonoMovil(item.getTelefono_movil());
			ImagenTienda imagen = imagenTiendaService.obtenerImagenPorDefectoTienda(item.getId());
			if (imagen != null)
				_tienda.setImagen(imagen.getImagen());
			if (item.getDistancia() != null)
				_tienda.setDistancia(Double.parseDouble(item.getDistancia()));
			for (Direccion direccion : item.getDirecciones()) {
				_tienda.setDomicilio(direccion.getDomicilio());
				_tienda.setNumero(direccion.getNumero());
				Distrito distrito = direccion.getDistrito();
				_tienda.setDistrito(distrito.getNombre());
				_tienda.setLatitud(direccion.getLatitud());
				_tienda.setLongitud(direccion.getLongitud());
				break;
			}
			tiendasLite.add(_tienda);
		}
		return tiendasLite;
	}

	@RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
	public ResponseEntity<List<Tienda>> listarTiendas() {
		List<Tienda> tiendas = service.listarTiendas();
		if (tiendas.isEmpty()) {
			return new ResponseEntity<List<Tienda>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Tienda>>(tiendas, HttpStatus.OK);
	}

	@RequestMapping(value = { "/listarTiendasPorCobertura" }, method = RequestMethod.GET)
	public ResponseEntity<List<TiendaVMLite>> listarTiendasPorCobertura(@RequestParam String latitud,
			@RequestParam String longitud) {
		List<Tienda> tiendas = new ArrayList<>();
		List<Direccion> direcciones = direccionService.listarDirecciones();
		double latitudCliente = Double.parseDouble(latitud);
		double longitudCliente = Double.parseDouble(longitud);
		for (Direccion item : direcciones) {
			double latitudTienda = Double.parseDouble(item.getLatitud());
			double longitudTienda = Double.parseDouble(item.getLongitud());
			double distancia = DistanceCalculatorUtil.distance(latitudCliente, longitudCliente, latitudTienda,
					longitudTienda, "K");
			if (distancia < DistanceCalculatorUtil.RADIO_USUARIO) {
				Tienda tienda = service.obtenerTiendaPorDireccion(item.getId());
				if(tienda!=null){
					distancia = distancia * 1000;				
					tienda.setDistancia(Double.toString(distancia));
					tiendas.add(tienda);
				}
			}
		}
		List<TiendaVMLite> tiendasLite = clonarTiendasVMLite(tiendas);

		tiendasLite.sort(Comparator.comparing(TiendaVMLite::getDistancia));

		if (tiendasLite.isEmpty()) {
			return new ResponseEntity<List<TiendaVMLite>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TiendaVMLite>>(tiendasLite, HttpStatus.OK);
	}

	@RequestMapping(value = { "/listarPorVendedor" }, params = { "id" }, method = RequestMethod.GET)
	public ResponseEntity<List<Tienda>> listarPorVendedor(int id) {
		List<Tienda> tiendas = service.listarPorVendedor(id);
		if (tiendas.isEmpty()) {
			return new ResponseEntity<List<Tienda>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Tienda>>(tiendas, HttpStatus.OK);
	}

	@RequestMapping(value = { "/listarPorDistrito" }, params = { "id" }, method = RequestMethod.GET)
	public ResponseEntity<List<TiendaVMLite>> listarPorDistrito(@RequestParam int id) {
		List<Tienda> tiendas = service.listarPorDistrito(id);
		if ((tiendas == null) || (tiendas.isEmpty())) {
			return new ResponseEntity<List<TiendaVMLite>>(HttpStatus.NO_CONTENT);
		}

		List<TiendaVMLite> tiendasLite = clonarTiendasVMLite(tiendas);

		return new ResponseEntity<List<TiendaVMLite>>(tiendasLite, HttpStatus.OK);
	}

	@RequestMapping(value = "/obtenerPorId", params = {
			"id" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tienda> obtenerPorId(@RequestParam("id") int id) {
		Tienda tienda = service.obtenerPorId(id);
		if (tienda == null) {
			return new ResponseEntity<Tienda>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Tienda>(tienda, HttpStatus.OK);
	}

	@RequestMapping(value = "/obtenerTiendasPorNombre", params = {
			"nombre" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TiendaVMLite>> obtenerTiendasPorNombre(@RequestParam("nombre") String nombre) {
		List<Tienda> tiendas = service.obtenerTiendasPorNombre(nombre);
		if ((tiendas == null) || (tiendas.isEmpty())) {
			return new ResponseEntity<List<TiendaVMLite>>(HttpStatus.NO_CONTENT);
		}

		List<TiendaVMLite> tiendasLite = clonarTiendasVMLite(tiendas);

		if (tiendasLite.isEmpty()) {
			return new ResponseEntity<List<TiendaVMLite>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TiendaVMLite>>(tiendasLite, HttpStatus.OK);
	}

	@RequestMapping(value = "/obtenerTiendasPorNombreDistrito", params = { "nombre",
			"id" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TiendaVMLite>> obtenerTiendasPorNombreDistrito(@RequestParam("nombre") String nombre,
			@RequestParam("id") int id) {
		List<Tienda> tiendas = service.obtenerTiendasPorNombreDistrito(nombre, id);
		if ((tiendas == null) || (tiendas.isEmpty())) {
			return new ResponseEntity<List<TiendaVMLite>>(HttpStatus.NO_CONTENT);
		}

		List<TiendaVMLite> tiendasLite = clonarTiendasVMLite(tiendas);

		if (tiendasLite.isEmpty()) {
			return new ResponseEntity<List<TiendaVMLite>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TiendaVMLite>>(tiendasLite, HttpStatus.OK);
	}

	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public ResponseEntity<Void> agregar(@RequestBody TiendaVM tienda, UriComponentsBuilder ucBuilder) {

		Tienda tiendaBean = new Tienda();
		tiendaBean.setNombre(tienda.getNombre());
		tiendaBean.setRuc(tienda.getRuc());
		tiendaBean.setTelefono_local(tienda.getTelefono_local());
		tiendaBean.setTelefono_movil(tienda.getTelefono_movil());
		tiendaBean.setAfiliacion(tienda.getAfiliacion());
		tiendaBean.setAfiliacion_valor(tienda.getAfiliacion_valor());
		tiendaBean.setCostoMinimo(tienda.getCostoMinimo());
		tiendaBean.setHorarioAtencion(tienda.getHorarioAtencion());
		tiendaBean.setEstado(TipoEstado.HABILITADO.getValue());
		List<Usuario> usuarios = new ArrayList<>();
		if (tienda.getId_usuarios() != null) {
			for (int id_usuario : tienda.getId_usuarios()) {
				Usuario usuario = service.obtenerUsuario(id_usuario);
				if (usuario == null) {
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				}
				usuarios.add(usuario);
			}
		}
		tiendaBean.setUsuarios(new HashSet<Usuario>(usuarios));
		tiendaBean.setEstadoAbierto(tienda.getEstadoAbierto());
		tiendaBean.setFechaRegistro(new Date());
		tiendaBean.setFechaModificacion(new Date());

		List<MetodoPago> metodoPagos = new ArrayList<>();
		for(int indice : tienda.getMetodoPagos()){
			MetodoPago metodoPago = service.obtenerMetodoPago(indice);
			metodoPagos.add(metodoPago);
		}
		tiendaBean.setMetodoPagos(new HashSet<MetodoPago>(metodoPagos));
		
		List<Envio> envios = new ArrayList<>();
		for(int indice : tienda.getEnvios()){
			Envio envio = service.obtenerEnvio(indice);
			envios.add(envio);
		}
		tiendaBean.setEnvios(new HashSet<Envio>(envios));
		
		tiendaBean.setMetodoPagos(new HashSet<MetodoPago>(metodoPagos));

		service.agregar(tiendaBean);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/tienda/{nombre}").buildAndExpand(tienda.getNombre()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody TiendaVM tienda, UriComponentsBuilder ucBuilder) {

		Tienda tiendaBean = new Tienda();
		tiendaBean.setId(tienda.getId());
		tiendaBean.setNombre(tienda.getNombre());
		tiendaBean.setRuc(tienda.getRuc());
		tiendaBean.setTelefono_local(tienda.getTelefono_local());
		tiendaBean.setTelefono_movil(tienda.getTelefono_movil());
		tiendaBean.setAfiliacion(tienda.getAfiliacion());
		tiendaBean.setAfiliacion_valor(tienda.getAfiliacion_valor());
		tiendaBean.setCostoMinimo(tienda.getCostoMinimo());
		tiendaBean.setHorarioAtencion(tienda.getHorarioAtencion());
		List<Usuario> usuarios = new ArrayList<>();
		if (tienda.getId_usuarios() != null) {
			for (int id_usuario : tienda.getId_usuarios()) {
				Usuario usuario = service.obtenerUsuario(id_usuario);
				if (usuario == null) {
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				}
				usuarios.add(usuario);
			}
		}
		tiendaBean.setUsuarios(new HashSet<Usuario>(usuarios));
		tiendaBean.setEstado(TipoEstado.HABILITADO.getValue());
		tiendaBean.setEstadoAbierto(tienda.getEstadoAbierto());
		tiendaBean.setFechaModificacion(new Date());

		List<MetodoPago> metodoPagos = new ArrayList<>();
		for(int indice : tienda.getMetodoPagos()){
			MetodoPago metodoPago = service.obtenerMetodoPago(indice);
			metodoPagos.add(metodoPago);
		}
		tiendaBean.setMetodoPagos(new HashSet<MetodoPago>(metodoPagos));
		
		List<Envio> envios = new ArrayList<>();
		for(int indice : tienda.getEnvios()){
			Envio envio = service.obtenerEnvio(indice);
			envios.add(envio);
		}
		tiendaBean.setEnvios(new HashSet<Envio>(envios));

		service.actulizar(tiendaBean);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/tienda/{nombre}").buildAndExpand(tienda.getNombre()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/eliminar", params = { "id" }, method = RequestMethod.DELETE)
	public ResponseEntity<Tienda> eliminar(@RequestParam("id") int id) {
		Tienda tienda = service.obtenerPorId(id);
		if (tienda == null) {
			return new ResponseEntity<Tienda>(HttpStatus.NO_CONTENT);
		}
		service.eliminar(id);
		return new ResponseEntity<Tienda>(HttpStatus.NO_CONTENT);
	}

	/************************************************************************************************/
	/******************************
	 * Imagenes de Producto
	 *****************************************/
	/************************************************************************************************/

	@RequestMapping(value = { "/imagen/listar" }, method = RequestMethod.GET)
	public ResponseEntity<List<ImagenTienda>> listarImagenes() {
		List<ImagenTienda> imagenes = imagenTiendaService.listarImagenes();
		if (imagenes.isEmpty()) {
			return new ResponseEntity<List<ImagenTienda>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ImagenTienda>>(imagenes, HttpStatus.OK);
	}

	@RequestMapping(value = "/imagen/obtenerPorId", params = {
			"id" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImagenTienda> obtenerImagenPorId(@RequestParam("id") int id) {
		ImagenTienda imagen = imagenTiendaService.obtenerImagenPorId(id);
		if (imagen == null) {
			return new ResponseEntity<ImagenTienda>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ImagenTienda>(imagen, HttpStatus.OK);
	}

	@RequestMapping(value = "/imagen/agregar", method = RequestMethod.POST)
	public ResponseEntity<Void> agregarImagen(@RequestBody ImagenProductoVM imagen, UriComponentsBuilder ucBuilder) {
		ImagenTienda imagenBean = new ImagenTienda();
		Tienda tienda = service.obtenerPorId(imagen.getId_tienda());

		if (tienda == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		imagenBean.setNombre(imagen.getNombre());
		imagenBean.setTienda(tienda);
		imagenBean.setImagen(imagen.getImagen());
		imagenBean.setDefecto(TipoImagen.SECUNDARIO.getValue());

		imagenTiendaService.agregarImagen(imagenBean);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/imagen/{nombre}").buildAndExpand(tienda.getNombre()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/imagen/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarImagen(@RequestBody ImagenProductoVM imagen, UriComponentsBuilder ucBuilder) {
		ImagenTienda imagenBean = new ImagenTienda();
		Tienda tienda = service.obtenerPorId(imagen.getId_tienda());

		if (tienda == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		imagenBean.setId(imagen.getId());
		imagenBean.setNombre(imagen.getNombre());
		imagenBean.setTienda(tienda);
		imagenBean.setImagen(imagen.getImagen());
		imagenBean.setDefecto(imagen.getId());

		imagenTiendaService.actualizarImagen(imagenBean);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/imagen/{nombre}").buildAndExpand(tienda.getNombre()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/imagen/eliminar", params = { "id" }, method = RequestMethod.DELETE)
	public ResponseEntity<ImagenTienda> eliminarImagen(@RequestParam("id") int id) {
		ImagenTienda tienda = imagenTiendaService.obtenerImagenPorId(id);
		if (tienda == null) {
			return new ResponseEntity<ImagenTienda>(HttpStatus.NO_CONTENT);
		}
		imagenTiendaService.eliminarImagen(id);
		;
		return new ResponseEntity<ImagenTienda>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = { "/imagen/listarImagenesPorTienda" }, method = RequestMethod.GET)
	public ResponseEntity<List<ImagenTienda>> listarImagenesPorTienda(int id) {
		List<ImagenTienda> imagenes = imagenTiendaService.listarImagenesPorTienda(id);
		if (imagenes.isEmpty()) {
			return new ResponseEntity<List<ImagenTienda>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ImagenTienda>>(imagenes, HttpStatus.OK);
	}

}

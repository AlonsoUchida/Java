package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.MetodoPagoDao;
import com.valmar.ecommerce.dao.TiendaDao;
import com.valmar.ecommerce.dao.UsuarioDao;
import com.valmar.ecommerce.model.MetodoPago;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.TiendaService;


@Service("tiendaService")
@Transactional
public class TiendaServiceImpl implements TiendaService{

	@Autowired
	TiendaDao tiendaDao;
	@Autowired
	UsuarioDao usuarioDao;
	@Autowired
	MetodoPagoDao metodoPagoDao;
	
	@Override
	public Tienda obtenerPorId(int id) {
		return tiendaDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Tienda tienda) {
		tiendaDao.agregar(tienda);
	}

	@Override
	public void eliminar(int id) {
		tiendaDao.eliminar(id);
	}

	@Override
	public List<Tienda> listarTiendas() {
		return tiendaDao.listarTiendas();
	}

	@Override
	public Usuario obtenerUsuario(int id_usuario) {
		return usuarioDao.obtenerPorId(id_usuario);
	}

	@Override
	public MetodoPago obtenerMetodoPago(int id_metodoPago) {
		return metodoPagoDao.obtenerPorId(id_metodoPago);
	}

	@Override
	public void actulizar(Tienda tiendaBean) {
		tiendaDao.actualizar(tiendaBean);		
	}

	@Override
	public List<Tienda> obtenerTiendasPorNombre(String nombre) {
		return tiendaDao.obtenerTiendasPorNombre(nombre);
	}

	@Override
	public List<Tienda> listarPorDistrito(int id) {
		return tiendaDao.listarPorDistrito(id);
	}

	@Override
	public List<Tienda> obtenerTiendasPorNombreDistrito(String nombre, int id) {
		return tiendaDao.obtenerTiendasPorNombreDistrito(nombre, id);
	}

	@Override
	public List<Tienda> listarPorVendedor(int id) {
		return tiendaDao.listarPorVendedor(id);
	}

	@Override
	public Tienda obtenerTiendaPorDireccion(int id) {
		return tiendaDao.obtenerTiendaPorDireccion(id);
	}

}

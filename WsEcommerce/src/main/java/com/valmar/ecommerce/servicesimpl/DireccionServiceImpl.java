package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.DepartamentoDao;
import com.valmar.ecommerce.dao.DireccionDao;
import com.valmar.ecommerce.dao.DistritoDao;
import com.valmar.ecommerce.dao.ProvinciaDao;
import com.valmar.ecommerce.dao.TiendaDao;
import com.valmar.ecommerce.dao.UsuarioDao;
import com.valmar.ecommerce.model.Departamento;
import com.valmar.ecommerce.model.Direccion;
import com.valmar.ecommerce.model.Distrito;
import com.valmar.ecommerce.model.Provincia;
import com.valmar.ecommerce.model.Tienda;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.DireccionService;


@Service("direccionService")
@Transactional
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionDao direccionDao;
	@Autowired
	private ProvinciaDao provinciaDao;
	@Autowired
	private DepartamentoDao departamentoDao;
	@Autowired
	private DistritoDao distritoDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private TiendaDao tiendaDao;
	
	@Override
	public Direccion obtenerPorId(int id) {
		return direccionDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Direccion direccion) {
		direccionDao.agregar(direccion);		
	}
	
	@Override
	public void actualizar(Direccion direccion) {
		direccionDao.actualizar(direccion);
		
	}

	@Override
	public void eliminar(int id) {
		direccionDao.eliminar(id);
		
	}

	@Override
	public List<Direccion> listarDirecciones() {
		return direccionDao.listarDirecciones();
	}

	@Override
	public Provincia obtenerProvinciaPorId(int id) {
		return provinciaDao.obtenerPorId(id);
	}

	@Override
	public Departamento obtenerDepartamentoPorId(int id) {
		return departamentoDao.obtenerPorId(id);
	}

	@Override
	public Distrito obtenerDistritoPorId(int id) {
		return distritoDao.obtenerPorId(id);
	}

	@Override
	public Usuario obtenerUsuarioPorId(int id) {
		return usuarioDao.obtenerPorId(id);
	}

	@Override
	public Tienda obtenerTiendaPorId(int id) {
		return tiendaDao.obtenerPorId(id);
	}

	@Override
	public List<Direccion> listarPorTienda(Integer id) {
		return direccionDao.listarPorTienda(id);
	}

}

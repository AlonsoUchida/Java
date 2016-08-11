package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ClienteDao;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.ClienteService;


@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public Usuario obtenerPorId(int id) {
		return clienteDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Usuario cliente) {
		clienteDao.agregar(cliente);		
	}

	@Override
	public void eliminar(int id) {
		clienteDao.eliminar(id);
		
	}

	@Override
	public List<Usuario> listarClientes() {
		return clienteDao.listarClientes();
	}

	@Override
	public Usuario obtenerPorCorreo(String username) {
		return clienteDao.obtenerPorCorreo(username);
	}

	@Override
	public void actualizar(Usuario cliente) {
		clienteDao.actualizar(cliente);		
	}


}

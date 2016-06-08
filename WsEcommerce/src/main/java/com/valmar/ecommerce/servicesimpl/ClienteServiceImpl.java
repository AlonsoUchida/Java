package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ClienteDao;
import com.valmar.ecommerce.model.Cliente;
import com.valmar.ecommerce.services.ClienteService;


@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public Cliente obtenerPorId(int id) {
		return clienteDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Cliente cliente) {
		clienteDao.agregar(cliente);		
	}

	@Override
	public void eliminar(int id) {
		clienteDao.eliminar(id);
		
	}

	@Override
	public List<Cliente> listarClientes() {
		return clienteDao.listarClientes();
	}


}

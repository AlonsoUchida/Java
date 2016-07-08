package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.ContactoDao;
import com.valmar.ecommerce.model.Contacto;
import com.valmar.ecommerce.services.ContactoService;

@Service("contactoService")
@Transactional
public class ContactoServiceImpl implements ContactoService{

	@Autowired
	ContactoDao contactoDao;
	
	@Override
	public Contacto obtenerPorId(int id) {
		return contactoDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Contacto contacto) {
		contactoDao.agregar(contacto);		
	}

	@Override
	public void actualizar(Contacto contacto) {
		contactoDao.actualizar(contacto);
	}

	@Override
	public void eliminar(int id) {
		contactoDao.eliminar(id);		
	}

	@Override
	public List<Contacto> listarContactos() {
		return contactoDao.listarContactos();
	}
	
}

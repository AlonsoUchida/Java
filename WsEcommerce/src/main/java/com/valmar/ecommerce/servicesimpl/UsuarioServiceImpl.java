package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.UsuarioDao;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.UsuarioService;


@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public Usuario obtenerPorId(int id) {
		return usuarioDao.obtenerPorId(id);
	}

	@Override
	public void agregar(Usuario usuario) {
		usuarioDao.agregar(usuario);
		
	}

	@Override
	public void eliminar(int id) {
		usuarioDao.eliminar(id);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.listarUsuarios();
	}

}

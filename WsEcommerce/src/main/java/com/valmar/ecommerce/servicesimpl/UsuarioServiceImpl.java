package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.TokenDao;
import com.valmar.ecommerce.dao.UsuarioDao;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.UsuarioService;
import com.valmar.ecommerce.viewmodel.ReporteVM;


@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	private TokenDao tokenDao;
	
	@Override
	public Usuario obtenerPorId(int id) {
		return usuarioDao.obtenerPorId(id);
	}

	@Override
	public int agregar(Usuario usuario) {
		return usuarioDao.agregar(usuario);
		
	}
	
	@Override
	public void actualizar(Usuario usuario) {
		usuarioDao.actualizar(usuario);
	}

	@Override
	public void eliminar(int id) {
		usuarioDao.eliminar(id);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.listarUsuarios();
	}

	@Override
	public int validarUsuario(String username, String password) {
		return usuarioDao.validarUsuario(username, password);
	}

	@Override
	public String generarToken(int userId) {
		Usuario user = usuarioDao.obtenerPorId(userId);
		if(user!=null)
			return tokenDao.generarToken(user);
		else 
			return null;
	}
	
	@Override
	public boolean validarToken(String token){
		return tokenDao.validarToken(token);
	}
	
	@Override
	public String obtenerUsuarioPorToken(String token){
		return tokenDao.obtenerUsuarioPorToken(token);
	}
	
	@Override
    public Usuario obtenerPorCorreo(String username) {
       return usuarioDao.obtenerPorCorreo(username);
    }

	@Override
	public List<Usuario> listarVendedores() {
		return usuarioDao.listarVendedores();
	}

	@Override
	public Usuario obtenerPorCorreoVendedor(String username) {
		return usuarioDao.obtenerPorCorreoVendedor(username);
	}

	@Override
	public List<Usuario> listarUsuariosPorVendedor(int id) {
		return usuarioDao.listarUsuariosPorVendedor(id);
	}

	@Override
	public Usuario obtenerPorCorreoCliente(String username) {
		return usuarioDao.obtenerPorCorreoCliente(username);
	}

	@Override
	public List<ReporteVM> obtenerReporteRegistrosPorVendedor(int id) {
		return usuarioDao.obtenerReporteRegistrosPorVendedor(id);
	}

}

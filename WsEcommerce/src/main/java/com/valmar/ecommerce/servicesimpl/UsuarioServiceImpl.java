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
	public void agregar(Usuario usuario) {
		usuarioDao.agregar(usuario);
		
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

	public int validateUser(String username, String password) {
		return usuarioDao.validateUser(username, password);
	}

	public String generateToken(int userId) {
		Usuario user = usuarioDao.getUserById(userId);
		if(user!=null)
			return tokenDao.generateToken(user);
		else 
			return null;
	}
	
	public boolean validateToken(String token){
		return tokenDao.validateToken(token);
	}
	
	public String getUsernameFromToken(String token){
		return tokenDao.getUsernameFromToken(token);
	}
	
	@Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) {
            return null;
        } else {
            return usuario;
        }
    }
}

package com.valmar.ecommerce.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valmar.ecommerce.dao.AuthorityDao;
import com.valmar.ecommerce.dao.UsuarioDao;
import com.valmar.ecommerce.model.Authority;
import com.valmar.ecommerce.model.JwtUserFactory;
import com.valmar.ecommerce.model.Usuario;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private AuthorityDao authorityDao;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario user = usuarioDao.obtenerPorCorreo(username);
       List<Authority> authorities = authorityDao.obtenerRolesPorUsuario(user.getId());
       user.setAuthorities(authorities);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}

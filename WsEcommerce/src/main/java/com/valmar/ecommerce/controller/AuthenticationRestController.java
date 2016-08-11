package com.valmar.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valmar.ecommerce.security.JwtTokenUtil;
import com.valmar.ecommerce.model.AuthenticationRequest;
import com.valmar.ecommerce.model.Usuario;
import com.valmar.ecommerce.services.ClienteService;
import com.valmar.ecommerce.services.UsuarioService;
import com.valmar.ecommerce.util.EncryptUtil;
import com.valmar.ecommerce.viewmodel.AuthenticationVM;

@CrossOrigin
@RestController
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UsuarioService usuarioService;

    /**
     * @param authorization
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestHeader("Authorization") String authorization) throws AuthenticationException {
    	AuthenticationRequest authenticationRequest = jwtTokenUtil.getAuthenticationRequest(authorization);
		Usuario usuario = usuarioService.obtenerPorCorreo(authenticationRequest.getUsername());
		return authenticationToken(authenticationRequest, usuario);    	
    }
    
    
    @RequestMapping(value = "/authenticate_vendedor", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateVendedor(@RequestHeader("Authorization") String authorization) throws AuthenticationException {
    	AuthenticationRequest authenticationRequest = jwtTokenUtil.getAuthenticationRequest(authorization);
		Usuario usuario = usuarioService.obtenerPorCorreoVendedor(authenticationRequest.getUsername());		
    	return authenticationToken(authenticationRequest, usuario);		
    }
    
    @RequestMapping(value = "/authenticate_cliente", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateCliente(@RequestHeader("Authorization") String authorization) throws AuthenticationException {
    	AuthenticationRequest authenticationRequest = jwtTokenUtil.getAuthenticationRequest(authorization);
		Usuario usuario = usuarioService.obtenerPorCorreoCliente(authenticationRequest.getUsername());		
    	return authenticationToken(authenticationRequest, usuario);		
    }
    
    /**
    * Esta función realiza la autenticación de las credenciales
    * mediante basic authentication.
    *
    * @author  Alonso Uchida
    * @version 1.0
    */
    private ResponseEntity<?> authenticationToken(AuthenticationRequest authenticationRequest, Usuario usuario){
    	if (usuario == null)
			return new ResponseEntity<String>("Usuario no existe", HttpStatus.NO_CONTENT);
		
		int userId = 0;		
		try {
			String username = authenticationRequest.getUsername();
			String password = EncryptUtil.encriptar(authenticationRequest.getPassword());
			userId = usuarioService.validarUsuario(username, password);
			if (userId == 0)
				return new ResponseEntity<String>("Crendeciales incorrectas", HttpStatus.UNAUTHORIZED);

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			final Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AuthenticationVM authVM = new AuthenticationVM();
		String token = usuarioService.generarToken(userId);
		authVM.setIdUsuario(usuario.getId());
		authVM.setNombre(usuario.getNombre());
		authVM.setApellido(usuario.getApellido());
		authVM.setToken(token);
		authVM.setTipo(usuario.getTipo());
		
		// Return the token
		return new ResponseEntity<AuthenticationVM>(authVM, HttpStatus.OK);
    }

}

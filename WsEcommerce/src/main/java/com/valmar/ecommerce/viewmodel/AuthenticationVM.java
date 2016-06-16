package com.valmar.ecommerce.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthenticationVM {

	private String token;
	private int idUsuario;
	@JsonIgnore
	private String password;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

package com.valmar.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRES", length = 200, unique = true)
	@NotNull
	@Size(min = 4, max = 200)
	private String nombres;
	
	@Column(name = "APELLIDOS", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 100)
	private String apellidos;
	
	@Column(name = "CORREO", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 100)
	private String correo;	
	
	@Column(name = "PASSWORD", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 100)
	private String password;	
	
	@Column(name = "ESTADO", length = 100, unique = true)
	@NotNull
	@Size(min = 1, max = 1)
	private int estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
}

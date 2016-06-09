package com.valmar.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRES", length = 150)
	@NotNull
	private String nombres;
	
	@Column(name = "APELLIDOS", length = 150)
	@NotNull
	private String apellidos;
	
	@Column(name = "CORREO", length = 150)
	@NotNull
	private String correo;	
	
	@Column(name = "PASSWORD", length = 250)
	@NotNull
	@Size(min = 4, max = 100)
	private String password;	
	
	@Column(name = "ESTADO", length = 2)
	@NotNull
	private int estado;


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

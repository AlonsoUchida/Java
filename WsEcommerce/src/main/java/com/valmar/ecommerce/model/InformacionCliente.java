package com.valmar.ecommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "informacion_cliente")
public class InformacionCliente {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@Column(name = "TELEFONO_LOCAL")
	private String telefonoLocal;
	
	@Column(name = "TELEFONO_MOVIL")
	private String telefonoMovil;
		
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_CLIENTE")
	@JsonIgnore
    private Usuario cliente;

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

	public String getTelefonoLocal() {
		return telefonoLocal;
	}

	public void setTelefonoLocal(String telefonoLocal) {
		this.telefonoLocal = telefonoLocal;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}	
	
}

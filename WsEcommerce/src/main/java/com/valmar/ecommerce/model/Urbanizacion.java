package com.valmar.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "urbanizacion")
public class Urbanizacion {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE", length = 500)
	@NotNull
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_DISTRITO")
	@JsonManagedReference
	private Distrito distrito;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	
}

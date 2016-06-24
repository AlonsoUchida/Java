package com.valmar.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "distrito")
public class Distrito {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE", length = 200, unique = true)
	@NotNull
	@Size(min = 4, max = 200)
	private String nombre;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_PROVINCIA")
	@JsonManagedReference
	private Provincia provincia;

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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}

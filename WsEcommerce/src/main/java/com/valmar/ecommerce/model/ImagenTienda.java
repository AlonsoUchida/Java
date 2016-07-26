package com.valmar.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "imagen_tienda")
public class ImagenTienda {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_TIENDA")
	@JsonIgnore
	private Tienda tienda;
	
	@Column(name = "NOMBRE")
	@NotNull
	private String nombre;
	
	@Column(name = "IMAGEN")
	private String imagen;
	
	@Column(name = "DEFECTO")
	private Integer defecto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getDefecto() {
		return defecto;
	}

	public void setDefecto(Integer defecto) {
		this.defecto = defecto;
	}
	
}

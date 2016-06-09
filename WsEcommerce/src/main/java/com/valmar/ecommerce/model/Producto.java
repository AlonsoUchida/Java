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
@Table(name = "producto")
public class Producto {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE", length = 200)
	@NotNull
	@Size(min = 4, max = 200)
	private String nombre;
	
	@Column(name = "DESCRIPCION", length = 200)
	@NotNull
	@Size(min = 4, max = 200)
	private String descripcion;
	
	@Column(name = "CARACTERISTICAS", length = 200)
	@NotNull
	@Size(min = 4, max = 200)
	private String caracteristicas;
	
	@Column(name = "PRECIO", length = 15)
	@NotNull
	@Size(min = 4, max = 15)
	private String precio;
	
	@Column(name = "INVENTARIO", length = 5)
	@NotNull
	@Size(min = 4, max = 5)
	private int inventario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_TIENDA")
	@JsonManagedReference
	private Tienda tienda;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	
}

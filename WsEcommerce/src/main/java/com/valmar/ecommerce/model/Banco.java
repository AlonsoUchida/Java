package com.valmar.ecommerce.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "banco")
public class Banco {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(
	      name="tienda_banco",
	      joinColumns=@JoinColumn(name="ID_BANCO", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="ID_TIENDA", referencedColumnName="ID"))
	@JsonIgnore
	private Set<Tienda> tiendas;

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

	public Set<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
	
}

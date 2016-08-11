package com.valmar.ecommerce.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "envio")
public class Envio {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ESTADO")
	private int estado;
		
	@ManyToMany(fetch = FetchType.EAGER)
	  @JoinTable(
	      name="tienda_envio",
	      joinColumns=@JoinColumn(name="ID_ENVIO", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="ID_TIENDA", referencedColumnName="ID"))
	@JsonBackReference
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Set<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

}

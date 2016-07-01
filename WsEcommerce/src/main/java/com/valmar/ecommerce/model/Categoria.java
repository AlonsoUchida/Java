package com.valmar.ecommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_CATEGORIA")
	@JsonIgnore
    private Categoria categoria;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Categoria> categorias;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy= "categorias")
	@JsonBackReference
	private Set<Producto> productos;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
		
}

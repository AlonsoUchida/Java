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
@Table(name = "tipo_tienda")
public class TipoTienda {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tienda_tipo_tienda",
            joinColumns = {@JoinColumn(name = "ID_TIPO_TIENDA", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID")})
	@JsonIgnore
    private Set<Tienda> tiendas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Tienda> getTienda() {
		return tiendas;
	}

	public void setTienda(Set<Tienda> tipoTiendas) {
		this.tiendas = tiendas;
	}
	
	
}

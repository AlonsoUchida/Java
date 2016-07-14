package com.valmar.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "direccion")
public class Direccion {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "REFERENCIA")
	private String referencia;
	
	@Column(name = "DOMICILIO")
	private String domicilio;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "LATITUD")
	private String latitud;
	
	@Column(name = "LONGITUD")
	private String longitud;
	
	@Column(name = "ACTIVO")
	private int activo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_DISTRITO")
	@JsonManagedReference
	private Distrito distrito;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_URBANIZACION")
	@JsonManagedReference
	private Urbanizacion urbanizacion;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "direcciones", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "direcciones", fetch = FetchType.LAZY)
    private List<Tienda> tiendas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
	
}

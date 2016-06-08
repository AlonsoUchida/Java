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
@Table(name = "DIRECCION")
public class Direccion {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "REFERENCIA", length = 200, unique = true)
	@NotNull
	@Size(min = 4, max = 200)
	private String referencia;
	
	@Column(name = "DOMICILIO", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 100)
	private String domicilio;
	
	@Column(name = "NUMERO", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 100)
	private String numero;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_PROVINCIA")
	@JsonManagedReference
	private Provincia provincia;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_DEPARTAMENTO")
	@JsonManagedReference
	private Departamento departamento;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_DISTRITO")
	@JsonManagedReference
	private Distrito distrito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	
}

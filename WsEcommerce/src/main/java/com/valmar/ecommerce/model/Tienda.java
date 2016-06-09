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
@Table(name = "tienda")
public class Tienda {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE", length = 200)
	@NotNull
	@Size(min = 4, max = 250)
	private String nombre;
	
	@Column(name = "RUC", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 30)
	private String ruc;
	
	@Column(name = "TELEFONO_LOCAL")
	@NotNull
	@Size(min = 1, max = 10)
	private String telefono_local;
	
	@Column(name = "TELEFONO_MOVIL")
	@NotNull
	@Size(min = 1, max = 10)
	private String telefono_movil;
	
	@Column(name = "AFILIACION")
	@NotNull
	private int afiliacion;
	
	@Column(name = "AFILIACION_VALOR")
	@NotNull
	private int afiliacion_valor;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_METODO_PAGO")
	@JsonManagedReference
	private MetodoPago metodoPago;
	
	@Column(name = "ESTADO", length=2)
	@NotNull
	private int estado;

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

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono_local() {
		return telefono_local;
	}

	public void setTelefono_local(String telefono_local) {
		this.telefono_local = telefono_local;
	}

	public String getTelefono_movil() {
		return telefono_movil;
	}

	public void setTelefono_movil(String telefono_movil) {
		this.telefono_movil = telefono_movil;
	}

	public int getAfiliacion() {
		return afiliacion;
	}

	public void setAfiliacion(int afiliacion) {
		this.afiliacion = afiliacion;
	}

	public int getAfiliacion_valor() {
		return afiliacion_valor;
	}

	public void setAfiliacion_valor(int afiliacion_valor) {
		this.afiliacion_valor = afiliacion_valor;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}

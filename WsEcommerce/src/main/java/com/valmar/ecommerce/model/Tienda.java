package com.valmar.ecommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tienda")
public class Tienda {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "RUC")
	@Size(min = 4, max = 30)
	private String ruc;
	
	@Column(name = "TELEFONO_LOCAL")
	private String telefono_local;
	
	@Column(name = "TELEFONO_MOVIL")
	private String telefono_movil;
	
	@Column(name = "AFILIACION")
	private int afiliacion;
	
	@Column(name = "AFILIACION_VALOR")
	private int afiliacion_valor;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	  @JoinTable(
	      name="TIENDA_METODO_PAGO",
	      joinColumns=@JoinColumn(name="ID_TIENDA", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="ID_METODO_PAGO", referencedColumnName="ID"))
	@JsonManagedReference
	private Set<MetodoPago> metodoPagos;
	
	@Column(name = "ESTADO")
	private int estado;
	
	@ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;

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
	
	public Set<MetodoPago> getMetodoPagos() {
		return metodoPagos;
	}

	public void setMetodoPagos(Set<MetodoPago> metodoPagos) {
		this.metodoPagos = metodoPagos;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}

package com.valmar.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orden")
public class Orden {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ESTADO_ORDEN")
	private String estadoOrden;
	
	@Column(name = "COSTO_ENVIO")
	private BigDecimal costoEnvio;
	
	@Column(name = "COSTO_TOTAL")
	private BigDecimal costoTotal;
	
	@Column(name = "FECHA_ENVIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvio;
	
	@Column(name = "FIRMA")
	private String firma;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "ordenes", fetch = FetchType.LAZY)
    private List<EstadoCuenta> estadoCuentas;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_DIRECCION_ENVIO")
	@JsonManagedReference
	private DireccionEnvio direccionEnvio;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_INFORMACION_CLIENTE")
	@JsonManagedReference
	private InformacionCliente informacionCliente;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_INFORMACION_PRODUCTO")
	@JsonManagedReference
	private InformacionProducto informacionProducto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstadoOrden() {
		return estadoOrden;
	}

	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	public BigDecimal getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(BigDecimal costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}	

	public DireccionEnvio getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(DireccionEnvio direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public InformacionCliente getInformacionCliente() {
		return informacionCliente;
	}

	public void setInformacionCliente(InformacionCliente informacionCliente) {
		this.informacionCliente = informacionCliente;
	}

	public InformacionProducto getInformacionProducto() {
		return informacionProducto;
	}

	public void setInformacionProducto(InformacionProducto informacionProducto) {
		this.informacionProducto = informacionProducto;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public List<EstadoCuenta> getEstadoCuentas() {
		return estadoCuentas;
	}

	public void setEstadoCuentas(List<EstadoCuenta> estadoCuentas) {
		this.estadoCuentas = estadoCuentas;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	
	
}

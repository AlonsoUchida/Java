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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "estado_cuenta")
public class EstadoCuenta {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_TIENDA")
	@JsonIgnore
    private Tienda tienda;

	@Column(name = "SALDO_ACUMULADO")
	private BigDecimal saldoAcumulado;
	
	@Column(name = "FECHA_LIMITE_PAGO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaLimitePago;
	
	@Column(name = "FECHA_ULTIMO_PAGO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltimoPago;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "estado_cuenta_orden",
            joinColumns = {@JoinColumn(name = "ID_ESTADO_CUENTA", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID")})
    private List<Orden> ordenes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public BigDecimal getSaldoAcumulado() {
		return saldoAcumulado;
	}

	public void setSaldoAcumulado(BigDecimal saldoAcumulado) {
		this.saldoAcumulado = saldoAcumulado;
	}

	public Date getFechaLimitePago() {
		return fechaLimitePago;
	}

	public void setFechaLimitePago(Date fechaLimitePago) {
		this.fechaLimitePago = fechaLimitePago;
	}

	public Date getFechaUltimoPago() {
		return fechaUltimoPago;
	}

	public void setFechaUltimoPago(Date fechaUltimoPago) {
		this.fechaUltimoPago = fechaUltimoPago;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	
	
}

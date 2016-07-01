package com.valmar.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tienda")
public class Tienda {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	      name="tienda_metodo_pago",
	      joinColumns=@JoinColumn(name="ID_TIENDA", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="ID_METODO_PAGO", referencedColumnName="ID"))
	@JsonManagedReference
	private Set<MetodoPago> metodoPagos;
	
	@Column(name = "COSTO_MINIMO")
	private BigDecimal costoMinimo;
	
	@Column(name = "ESTADO_ABIERTO")
	private int estadoAbierto;
	
	@Column(name = "IMAGEN")
	private byte[] imagen;
	
	@ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;
	
	@Column(name = "ESTADO")
	private int estado;
	
	@Column(name = "FECHA_REGISTRO", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@Column(name = "FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tienda", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Producto> productos;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tienda_direccion",
            joinColumns = {@JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID")})
    private Set<Direccion> direcciones;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tienda", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<EstadoCuenta> estadoCuentas;
		
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

	public BigDecimal getCostoMinimo() {
		return costoMinimo;
	}

	public void setCostoMinimo(BigDecimal costoMinimo) {
		this.costoMinimo = costoMinimo;
	}

	public int getEstadoAbierto() {
		return estadoAbierto;
	}

	public void setEstadoAbierto(int estadoAbierto) {
		this.estadoAbierto = estadoAbierto;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Set<EstadoCuenta> getEstadoCuentas() {
		return estadoCuentas;
	}

	public void setEstadoCuentas(Set<EstadoCuenta> estadoCuentas) {
		this.estadoCuentas = estadoCuentas;
	}
		
}

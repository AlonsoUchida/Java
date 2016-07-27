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
import javax.persistence.Transient;
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
		
	@Column(name = "COSTO_MINIMO")
	private BigDecimal costoMinimo;
	
	@Column(name = "ESTADO_ABIERTO")
	private int estadoAbierto;
	
	@Column(name = "HORARIO_ATENCION")
	private String horarioAtencion;
	
	@Column(name = "PAGINAWEB")
	private String paginaweb;
	
	@Column(name = "TARJETA")
	private Integer tarjeta;
	
	@ManyToMany(fetch = FetchType.EAGER)
	  @JoinTable(
	      name="tienda_banco",
	      joinColumns=@JoinColumn(name="ID_TIENDA", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="ID_BANCO", referencedColumnName="ID"))
	private Set<Banco> bancos;
	
	@Column(name = "ESTADO")
	private int estado;
	
	@Column(name = "FECHA_REGISTRO", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@Column(name = "FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tienda", cascade = CascadeType.ALL)	
	private Set<Producto> productos;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(
	      name="tienda_metodo_pago",
	      joinColumns=@JoinColumn(name="ID_TIENDA", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="ID_METODO_PAGO", referencedColumnName="ID"))
	@JsonIgnore
	private Set<MetodoPago> metodoPagos;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(
	      name="tienda_envio",
	      joinColumns=@JoinColumn(name="ID_TIENDA", referencedColumnName="ID"),
	      inverseJoinColumns=@JoinColumn(name="ID_ENVIO", referencedColumnName="ID"))
	@JsonIgnore
	private Set<Envio> envios;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tienda_direccion",
            joinColumns = {@JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID")})
    private Set<Direccion> direccionesTienda;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tienda", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<EstadoCuenta> estadoCuentas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tienda", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<ImagenTienda> imagenes;	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="tiendas")
	private Set<Usuario> usuarios;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tienda_tipo_tienda",
            joinColumns = {@JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_TIPO_TIENDA", referencedColumnName = "ID")})
    private Set<TipoTienda> tipoTiendas;
	
	@Transient
	private String distancia;
		
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
		
	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
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

	public Set<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(Set<Envio> envios) {
		this.envios = envios;
	}

	public Set<Direccion> getDireccionesTienda() {
		return direccionesTienda;
	}

	public void setDireccionesTienda(Set<Direccion> direccionesTienda) {
		this.direccionesTienda = direccionesTienda;
	}

	public Set<EstadoCuenta> getEstadoCuentas() {
		return estadoCuentas;
	}

	public void setEstadoCuentas(Set<EstadoCuenta> estadoCuentas) {
		this.estadoCuentas = estadoCuentas;
	}

	public Set<ImagenTienda> getImagenes() {
		return imagenes;
	}

	public void setImagenes(Set<ImagenTienda> imagenes) {
		this.imagenes = imagenes;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getPaginaweb() {
		return paginaweb;
	}

	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}

	public Integer getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Integer tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Set<Banco> getBancos() {
		return bancos;
	}

	public void setBancos(Set<Banco> bancos) {
		this.bancos = bancos;
	}

	public Set<TipoTienda> getTipoTiendas() {
		return tipoTiendas;
	}

	public void setTipoTiendas(Set<TipoTienda> tipoTiendas) {
		this.tipoTiendas = tipoTiendas;
	}	
	
}

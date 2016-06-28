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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "CARACTERISTICAS")
	private String caracteristicas;
	
	@Column(name = "PRECIO")
	@Digits(integer=7, fraction=2)
	private BigDecimal precio;
		
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_MARCA")
	@JsonManagedReference
    private Marca marca;
	
	@Column(name = "PRESENTACION")
	private String presentacion;
	
	@Column(name = "DESCUENTO")
	@Digits(integer=7, fraction=2)
	private BigDecimal descuento;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_TIENDA")
	@JsonManagedReference
	private Tienda tienda;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "producto_categoria",
            joinColumns = {@JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID")})
    private List<Categoria> categorias;
	
	@Column(name = "ESTADO")
	private int estado;
	
	@Column(name = "FECHA_REGISTRO", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@Column(name = "FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "producto", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<ImagenProducto> imagenes;	

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	public Set<ImagenProducto> getImagenes() {
		return imagenes;
	}

	public void setImagenes(Set<ImagenProducto> imagenes) {
		this.imagenes = imagenes;
	}
	
}

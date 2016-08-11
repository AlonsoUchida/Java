package com.valmar.ecommerce.viewmodel;

import java.math.BigDecimal;

public class ProductoVM {

	private int id;
	private String nombre;	
	private String descripcion;	
	private String caracteristicas;
	private BigDecimal precio;		
	private int id_marca;	
	private String presentacion;
	private BigDecimal descuento;		
	private int id_tienda;	
	private int[] id_categoria;
	
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
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
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
	public int getId_tienda() {
		return id_tienda;
	}
	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}
	public int[] getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int[] id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	
}

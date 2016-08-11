package com.valmar.ecommerce.viewmodel;

public class ImagenProductoVM {
	
	private int id;
	private int id_producto;
	private int id_tienda;
	private String nombre;	
	private String imagen;
	private int defecto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}	
	public int getId_tienda() {
		return id_tienda;
	}
	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getDefecto() {
		return defecto;
	}
	public void setDefecto(int defecto) {
		this.defecto = defecto;
	}
	
	
}

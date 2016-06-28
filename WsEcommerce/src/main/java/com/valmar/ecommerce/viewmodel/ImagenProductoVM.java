package com.valmar.ecommerce.viewmodel;


public class ImagenProductoVM {
	
	private int id;
	private int id_producto;
	private String nombre;	
	private byte[] imagen;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public int getDefecto() {
		return defecto;
	}
	public void setDefecto(int defecto) {
		this.defecto = defecto;
	}
	
	
}

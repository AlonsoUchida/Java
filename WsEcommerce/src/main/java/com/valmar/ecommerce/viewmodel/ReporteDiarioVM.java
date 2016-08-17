package com.valmar.ecommerce.viewmodel;

public class ReporteDiarioVM {

	private int id;
	private Integer id_usuario;
	private Integer id_tienda;
	private String nombre;
	private String observacion;
	private String latitud;
	private String longitud;
	private String fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Integer getId_tienda() {
		return id_tienda;
	}
	public void setId_tienda(Integer id_tienda) {
		this.id_tienda = id_tienda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}

package com.valmar.ecommerce.viewmodel;

import java.math.BigDecimal;

public class TiendaVM {

	private int id;
	private String nombre;
	private String ruc;
	private String telefono_local;
	private String telefono_movil;
	private int afiliacion;
	private int afiliacion_valor;
	private int[] metodoPagos;
	private BigDecimal costoMinimo;
	private String horarioAtencion;
	private int estadoAbierto;
	private byte[] imagen;	
    private int[] id_usuarios;
	
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
	public int[] getMetodoPagos() {
		return metodoPagos;
	}
	public void setMetodoPagos(int[] metodoPagos) {
		this.metodoPagos = metodoPagos;
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
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public int[] getId_usuarios() {
		return id_usuarios;
	}
	public void setId_usuarios(int[] id_usuarios) {
		this.id_usuarios = id_usuarios;
	}
}

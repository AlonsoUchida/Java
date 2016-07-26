package com.valmar.ecommerce.viewmodel;

import java.math.BigDecimal;

import com.valmar.ecommerce.model.Banco;

public class TiendaVM {

	private int id;
	private String nombre;
	private String ruc;
	private String telefono_local;
	private String telefono_movil;
	private int afiliacion;
	private int afiliacion_valor;
	private int[] metodoPagos;
	private int[] envios;
	private BigDecimal costoMinimo;
	private String horarioAtencion;
	private int estadoAbierto;
	private String imagen;	
    private int[] id_usuarios;
	private String paginaweb;
	private int tarjeta;
	private int id_banco;
	private int[] id_tipo_tienda;
	
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int[] getId_usuarios() {
		return id_usuarios;
	}
	public void setId_usuarios(int[] id_usuarios) {
		this.id_usuarios = id_usuarios;
	}
	public int[] getEnvios() {
		return envios;
	}
	public void setEnvios(int[] envios) {
		this.envios = envios;
	}
	public String getPaginaweb() {
		return paginaweb;
	}
	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}
	public int getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}
	public int getId_banco() {
		return id_banco;
	}
	public void setId_banco(int id_banco) {
		this.id_banco = id_banco;
	}
	public int[] getId_tipo_tienda() {
		return id_tipo_tienda;
	}
	public void setId_tipo_tienda(int[] id_tipo_tienda) {
		this.id_tipo_tienda = id_tipo_tienda;
	}
	
}

package com.valmar.ecommerce.viewmodel;

public class BodegueroVM {

	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	private String genero;
	private int id_tipoDocumento; 
	private String valorDocumento;
	
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId_tipoDocumento() {
		return id_tipoDocumento;
	}

	public void setId_tipoDocumento(int id_tipoDocumento) {
		this.id_tipoDocumento = id_tipoDocumento;
	}

	public String getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(String valorDocumento) {
		this.valorDocumento = valorDocumento;
	}
	
}

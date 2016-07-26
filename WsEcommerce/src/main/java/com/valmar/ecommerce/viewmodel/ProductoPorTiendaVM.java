package com.valmar.ecommerce.viewmodel;

import java.math.BigDecimal;

public class ProductoPorTiendaVM extends ProductoVM{
	
	private String imagen;
	private BigDecimal costoMinimo;
	
	public BigDecimal getCostoMinimo() {
		return costoMinimo;
	}
	public void setCostoMinimo(BigDecimal costoMinimo) {
		this.costoMinimo = costoMinimo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}

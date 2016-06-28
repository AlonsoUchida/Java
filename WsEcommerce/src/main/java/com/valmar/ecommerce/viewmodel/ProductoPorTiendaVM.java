package com.valmar.ecommerce.viewmodel;

import java.math.BigDecimal;

public class ProductoPorTiendaVM extends ProductoVM{
	
	private byte[] imagen;
	private BigDecimal costoMinimo;
	
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public BigDecimal getCostoMinimo() {
		return costoMinimo;
	}
	public void setCostoMinimo(BigDecimal costoMinimo) {
		this.costoMinimo = costoMinimo;
	}
	
	
}

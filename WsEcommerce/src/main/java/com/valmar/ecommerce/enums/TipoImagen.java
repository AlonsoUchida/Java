package com.valmar.ecommerce.enums;

public enum TipoImagen {

	DEFECTO(1),
	SECUNDARIO(2);

	private int numVal;

	TipoImagen(int numVal) {
	        this.numVal = numVal;
	    }

	public int getValue() {
		return numVal;
	}
	
}

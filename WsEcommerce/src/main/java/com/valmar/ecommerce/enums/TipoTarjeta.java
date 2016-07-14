package com.valmar.ecommerce.enums;

public enum TipoTarjeta {

	TIENE(1),
	NOTIENE(2);

	private int numVal;

	TipoTarjeta(int numVal) {
	        this.numVal = numVal;
	    }

	public int getValue() {
		return numVal;
	}
}

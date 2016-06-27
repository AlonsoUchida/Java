package com.valmar.ecommerce.enums;

public enum TipoUsuario {
	
	BODEGUERO(1),
	CLIENTE(2);

	private int numVal;

	TipoUsuario(int numVal) {
	        this.numVal = numVal;
	    }

	public int getValue() {
		return numVal;
	}
}

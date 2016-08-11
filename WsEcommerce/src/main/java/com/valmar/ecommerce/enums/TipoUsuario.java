package com.valmar.ecommerce.enums;

public enum TipoUsuario {
	
	ADMINISTRADOR(0),
	BODEGUERO(1),
	CLIENTE(2),
	VENDEDOR(3);

	private int numVal;

	TipoUsuario(int numVal) {
	        this.numVal = numVal;
	    }

	public int getValue() {
		return numVal;
	}
}

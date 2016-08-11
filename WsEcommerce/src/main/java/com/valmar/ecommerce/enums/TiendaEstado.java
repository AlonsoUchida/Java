package com.valmar.ecommerce.enums;

public enum TiendaEstado {
	
	ABIERTO(1),
	CERRADO(2);

	private int numVal;

	TiendaEstado(int numVal) {
	        this.numVal = numVal;
	    }

	public int getValue() {
		return numVal;
	}
}

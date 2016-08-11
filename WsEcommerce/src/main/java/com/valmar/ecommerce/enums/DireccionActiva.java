package com.valmar.ecommerce.enums;

public enum DireccionActiva {
	
	ACTIVA(1),
	NO_ACTIVA(2);
	
	private int numVal;

	DireccionActiva(int numVal) {
	        this.numVal = numVal;
	    }

	public int getValue() {
		return numVal;
	}
}

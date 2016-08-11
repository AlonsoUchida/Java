package com.valmar.ecommerce.enums;

public enum TipoEstado{

	HABILITADO(1),
	ELIMINADO(2);

	private int numVal;

	TipoEstado(int numVal) {
	        this.numVal = numVal;
	    }

	public int getValue() {
		return numVal;
	}
}

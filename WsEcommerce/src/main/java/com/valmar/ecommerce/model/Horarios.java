package com.valmar.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "horarios")
public class Horarios {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "dia_inicial")
	private int dia_inicial;
	
	@Column(name= "dia_final")
	private int dia_final;
	
	@Column(name= "hora_inicial")
	private int hora_inicial;
	
	@Column(name= "hora_final")
	private int hora_final;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_TIENDA")
	@JsonIgnore
	private Tienda tienda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDia_inicial() {
		return dia_inicial;
	}

	public void setDia_inicial(int dia_inicial) {
		this.dia_inicial = dia_inicial;
	}

	public int getDia_final() {
		return dia_final;
	}

	public void setDia_final(int dia_final) {
		this.dia_final = dia_final;
	}

	public int getHora_inicial() {
		return hora_inicial;
	}

	public void setHora_inicial(int hora_inicial) {
		this.hora_inicial = hora_inicial;
	}

	public int getHora_final() {
		return hora_final;
	}

	public void setHora_final(int hora_final) {
		this.hora_final = hora_final;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	
}

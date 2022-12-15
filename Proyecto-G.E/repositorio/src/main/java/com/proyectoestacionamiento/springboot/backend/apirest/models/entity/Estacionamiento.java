package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name = "estacionamiento") 
public class Estacionamiento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "discapacitados")
	private boolean discapacitado;
	
	@NotNull
	@Column(name = "capacidad")
	private int cantidad;
	
	@NotNull
	@Column(name = "precio_por_minuto")
	private int precioPorMinuto;
	
	//falta la relacion 
	
	

	public int getIdEstacionamiento() {
		return id;
	}

	public void setIdEstacionamiento(int idEstacionamiento) {
		this.id = idEstacionamiento;
	}

	public boolean isDiscapacitado() {
		return discapacitado;
	}

	public void setDiscapacitado(boolean discapacitado) {
		this.discapacitado = discapacitado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioPorMinuto() {
		return precioPorMinuto;
	}

	public void setPrecioPorMinuto(int precioPorMinuto) {
		this.precioPorMinuto = precioPorMinuto;
	}

	public Estacionamiento(int idEstacionamiento, boolean discapacitado, @NotNull int cantidad,
			@NotNull int precioPorMinuto) {
		super();
		this.id = idEstacionamiento;
		this.discapacitado = discapacitado;
		this.cantidad = cantidad;
		this.precioPorMinuto = precioPorMinuto;
	}

	public Estacionamiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
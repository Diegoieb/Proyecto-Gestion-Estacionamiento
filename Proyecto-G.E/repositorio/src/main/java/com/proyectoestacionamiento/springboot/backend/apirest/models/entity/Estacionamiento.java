package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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


	//private ArrayList<Reseña> reseñas;

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
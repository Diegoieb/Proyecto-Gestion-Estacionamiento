package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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


	@JsonIgnoreProperties(value = {"estacionamiento", "hibernateLazyInitializer", "handler"}, allowSetters = true)
	@OneToMany(mappedBy = "estacionamiento")
	private Set<Reseña> reseñas = new HashSet<>();

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

	public Set<Reseña> getReseñas() {
		return reseñas;
	}

	public void setReseñas(Set<Reseña> reseñas) {
		this.reseñas = reseñas;
	}

	public Estacionamiento(int idEstacionamiento, boolean discapacitado, @NotNull int cantidad,
						   @NotNull int precioPorMinuto, Set<Reseña> reseñas) {
		super();
		this.id = idEstacionamiento;
		this.discapacitado = discapacitado;
		this.cantidad = cantidad;
		this.precioPorMinuto = precioPorMinuto;
		this.reseñas = reseñas;
	}

	public Estacionamiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
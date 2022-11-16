package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name = "vehiculo") 
public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	//Es para tipo numerico
	//notEmpty es para caracteres
	@NotEmpty
	private String patente;
	
	@NotEmpty
	private String color;
		

	@NotEmpty
	private String marca;
	
	private Boolean automatico;
	
	//para cuando llame al metodo no se llame de forma infinita, para que no se llamen entre si infinitamente
		@JsonIgnoreProperties(value = {"vehiculos","hibernateLazyInitializer","handler"}, allowSetters = true)
	    @ManyToOne()
	    @JoinColumn(name="id_cliente", referencedColumnName="id")
	    private Cliente cliente;
	
	public Vehiculo(int id, @NotEmpty String patente, @NotEmpty String color, @NotEmpty String marca,
			Boolean automatico, Cliente cliente) {
		super();
		this.id = id;
		this.patente = patente;
		this.color = color;
		this.marca = marca;
		this.automatico = automatico;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Boolean getAutomatico() {
		return automatico;
	}

	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	
}

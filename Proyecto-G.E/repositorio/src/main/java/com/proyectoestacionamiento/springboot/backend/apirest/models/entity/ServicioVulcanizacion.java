package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@DiscriminatorValue(value="vulcanizacion")
public class ServicioVulcanizacion extends Servicio{

	private boolean ocupado;
	
	private int precio;
	
	//para cuando llame al metodo no se llame de forma infinita, para que no se llamen entre si infinitamente
	//value=para el arreglo
	@JsonIgnoreProperties(value = {"serviciosVulcanizacion","hibernateLazyInitializer","handler"}, allowSetters = true)
    @ManyToOne()
    @JoinColumn(name="id_estacionamiento2", referencedColumnName="id")
    private Estacionamiento estacionamiento;
	
	@JsonIgnoreProperties(value = {"serviciosVulcanizacion","hibernateLazyInitializer","handler"}, allowSetters = true)
    @ManyToOne()
    @JoinColumn(name="id_trabajador", referencedColumnName="id")
    private Trabajador trabajador;

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Estacionamiento getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}



	public ServicioVulcanizacion(Long id, boolean ocupado, int precio, Estacionamiento estacionamiento,
			Trabajador trabajador) {
		super(id);
		this.ocupado = ocupado;
		this.precio = precio;
		this.estacionamiento = estacionamiento;
		this.trabajador = trabajador;
	}

	public ServicioVulcanizacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioVulcanizacion(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	
	
}

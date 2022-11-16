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
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	



	public ServicioVulcanizacion(Long id, @NotNull int precio, boolean ocupado, Estacionamiento estacionamiento,
			Trabajador trabajador) {
		super(id);
		this.ocupado = ocupado;
		this.estacionamiento = estacionamiento;
		this.trabajador = trabajador;
		this.precio = precio;
	}	

	public ServicioVulcanizacion() {
		super();
		// TODO Auto-generated constructor stub
	}



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
	
	
}

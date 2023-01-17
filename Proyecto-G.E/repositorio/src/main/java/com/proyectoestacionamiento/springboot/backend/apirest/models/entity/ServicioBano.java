package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue(value="bano")
public class ServicioBano extends Servicio {
	
	private boolean ocupado;
	
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

	public ServicioBano(int id, boolean ocupado, Estacionamiento estacionamiento, Trabajador trabajador) {
		super(id);
		this.ocupado = ocupado;
		this.estacionamiento = estacionamiento;
		this.trabajador = trabajador;
	}

	public ServicioBano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioBano(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
		

	
	
	
	

}

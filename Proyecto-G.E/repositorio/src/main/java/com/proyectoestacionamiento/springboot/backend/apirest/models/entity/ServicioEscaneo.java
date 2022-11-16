package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue(value="escaneo")
public class ServicioEscaneo extends Servicio {
	
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public ServicioEscaneo(Long id, boolean ocupado, int precio, Estacionamiento estacionamiento,
			Trabajador trabajador) {
		super(id);
		this.ocupado = ocupado;
		this.precio = precio;
		this.estacionamiento = estacionamiento;
		this.trabajador = trabajador;
	}

	public ServicioEscaneo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioEscaneo(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	

}

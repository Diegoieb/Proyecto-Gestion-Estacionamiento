package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.InheritanceType;


@Entity
@DiscriminatorColumn(name="tipo_servicio")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="servicio")
public abstract class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Servicio(Long id) {
		super();
		this.id = id;
	}

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

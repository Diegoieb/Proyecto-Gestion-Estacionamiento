package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;

public interface IServicioFleteService {

	public List<ServicioFlete> findAll();
	
	public ServicioFlete save(ServicioFlete ServicioFlete);
	
	public ServicioFlete findById(Integer id);
	
	public void delete(Integer id);
}

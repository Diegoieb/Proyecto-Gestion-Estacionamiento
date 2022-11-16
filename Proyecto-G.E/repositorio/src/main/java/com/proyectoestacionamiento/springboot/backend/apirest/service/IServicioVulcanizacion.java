package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;



public interface IServicioVulcanizacion {

	public List<ServicioVulcanizacion> findAll();
	
	public ServicioVulcanizacion save(ServicioVulcanizacion ServicioVulcanizacion);
	
	public ServicioVulcanizacion findById(Integer id);
	
	public void delete(Integer id);
}

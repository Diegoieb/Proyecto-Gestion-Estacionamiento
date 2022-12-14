package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;

import java.util.List;


public interface IServicioVulcanizacionService {

	List<ServicioVulcanizacion> findAll();

	ServicioVulcanizacion save(ServicioVulcanizacion ServicioVulcanizacion);

	ServicioVulcanizacion findById(Integer id);

	void delete(Integer id);
}
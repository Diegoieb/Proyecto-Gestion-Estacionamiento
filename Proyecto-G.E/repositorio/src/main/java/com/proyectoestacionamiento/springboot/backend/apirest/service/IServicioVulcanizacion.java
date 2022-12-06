package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import org.springframework.http.ResponseEntity;


public interface IServicioVulcanizacion {

	ResponseEntity<?> findAll();

	ServicioVulcanizacion save(ServicioVulcanizacion ServicioVulcanizacion);

	ServicioVulcanizacion findById(Integer id);

	void delete(Integer id);
}
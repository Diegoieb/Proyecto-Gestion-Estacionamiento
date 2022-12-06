package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import org.springframework.http.ResponseEntity;

import java.util.Map;


public interface IEstacionamientoService {
	
	ResponseEntity<Map<String, Object>> findAll();
	
	Estacionamiento save(Estacionamiento estacionamiento);
	
	Estacionamiento findById(Integer id);
	
	void delete(Integer id);

}

package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IEstacionamientoService {
	
	public List<Estacionamiento> findAll();
	
	public Estacionamiento save(Estacionamiento estacionamiento);
	
	public Estacionamiento findById(Integer id);
	
	public void delete(Integer id);

	ResponseEntity<?> obtenerEstacionamientosDiscapacitados();
}
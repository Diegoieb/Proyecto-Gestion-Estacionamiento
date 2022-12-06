package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import org.springframework.http.ResponseEntity;


public interface IVehiculoService {

	ResponseEntity<?> findAll();

	ResponseEntity<?> save(Vehiculo vehiculo);

	Vehiculo findById(Integer id);

	void delete(Integer id);
}

package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import org.springframework.http.ResponseEntity;

public interface ITrabajadorService {

	ResponseEntity<?> findAll();

	Trabajador save(Trabajador trabajador);

	Trabajador findById(Integer id);

	void delete(Integer id);
}

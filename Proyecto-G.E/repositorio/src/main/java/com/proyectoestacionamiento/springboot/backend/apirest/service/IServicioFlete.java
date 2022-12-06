package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;
import org.springframework.http.ResponseEntity;

public interface IServicioFlete {

	ResponseEntity<?> findAll();

	ServicioFlete save(ServicioFlete ServicioFlete);

	ServicioFlete findById(Integer id);

	void delete(Integer id);
}

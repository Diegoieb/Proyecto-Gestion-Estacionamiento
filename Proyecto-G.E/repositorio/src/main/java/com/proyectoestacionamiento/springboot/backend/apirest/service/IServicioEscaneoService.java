package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioEscaneo;
import org.springframework.http.ResponseEntity;


public interface IServicioEscaneoService {

	ResponseEntity<?> findAll();

	ServicioEscaneo save(ServicioEscaneo ServicioBano);

	ServicioEscaneo findById(Integer id);

	void delete(Integer id);
}

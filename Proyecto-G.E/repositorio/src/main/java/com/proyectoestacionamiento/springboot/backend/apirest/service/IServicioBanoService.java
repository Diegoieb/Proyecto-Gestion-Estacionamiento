package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;
import org.springframework.http.ResponseEntity;


public interface IServicioBanoService {

	ResponseEntity<?> findAll();

	ServicioBano save(ServicioBano ServicioBano);

	ServicioBano findById(Integer id);

	void delete(Integer id);

}

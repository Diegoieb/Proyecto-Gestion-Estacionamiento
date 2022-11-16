package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;

public interface IServicioBanoRepository extends JpaRepository<ServicioBano, Integer>{
	

}

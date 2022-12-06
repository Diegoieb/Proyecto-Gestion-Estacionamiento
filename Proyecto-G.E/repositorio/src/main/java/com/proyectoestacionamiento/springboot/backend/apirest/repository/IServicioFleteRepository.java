package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioFleteRepository extends JpaRepository<ServicioFlete, Integer> {

}

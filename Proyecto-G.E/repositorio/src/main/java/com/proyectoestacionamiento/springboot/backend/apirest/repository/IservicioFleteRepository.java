package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;

public interface IservicioFleteRepository extends JpaRepository<ServicioFlete, Integer> {

}

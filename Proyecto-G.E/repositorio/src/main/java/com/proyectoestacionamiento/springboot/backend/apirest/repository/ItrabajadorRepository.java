package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;

public interface ItrabajadorRepository extends JpaRepository<Trabajador, Integer> {

}

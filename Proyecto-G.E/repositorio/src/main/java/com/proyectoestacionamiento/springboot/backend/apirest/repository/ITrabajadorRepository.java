package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrabajadorRepository extends JpaRepository<Trabajador, Integer> {

}

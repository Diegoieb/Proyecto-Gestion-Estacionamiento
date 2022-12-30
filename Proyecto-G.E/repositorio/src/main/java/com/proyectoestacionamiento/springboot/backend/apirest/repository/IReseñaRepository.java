package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReseñaRepository extends JpaRepository<Reseña, Integer> {

}

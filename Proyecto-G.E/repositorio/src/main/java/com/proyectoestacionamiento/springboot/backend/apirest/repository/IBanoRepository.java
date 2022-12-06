package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBanoRepository extends JpaRepository<ServicioBano, Integer> {


}

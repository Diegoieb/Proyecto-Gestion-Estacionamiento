package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioVulcanizacionRepository extends JpaRepository<ServicioVulcanizacion, Integer> {

}

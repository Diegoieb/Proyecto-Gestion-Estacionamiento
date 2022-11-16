package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;

public interface IvehiculoRepository extends JpaRepository<Vehiculo, Integer> {

}

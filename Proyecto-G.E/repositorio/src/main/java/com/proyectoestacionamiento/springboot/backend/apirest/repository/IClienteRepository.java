package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}

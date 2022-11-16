package com.proyectoestacionamiento.springboot.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;

public interface IclienteRepository extends JpaRepository<Cliente, Integer> {

}

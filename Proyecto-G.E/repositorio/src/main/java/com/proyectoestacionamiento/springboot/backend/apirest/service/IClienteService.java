package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IClienteService {

	ResponseEntity<Map<String, Object>> findAll();

	ResponseEntity<?> save(Cliente cliente);

	ResponseEntity<?> findById(Integer id);

	ResponseEntity<?> updateCliente(Cliente cliente);

	ResponseEntity<?> delete(Integer id);
}

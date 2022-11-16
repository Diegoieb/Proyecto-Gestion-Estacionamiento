package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente save(Cliente cliente);
	
	public Cliente findById(Integer id);
	
	public void delete(Integer id);
}

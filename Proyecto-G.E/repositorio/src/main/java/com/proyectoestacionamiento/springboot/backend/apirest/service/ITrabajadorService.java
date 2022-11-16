package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;

public interface ITrabajadorService {

	public List<Trabajador> findAll();
	
	public Trabajador save(Trabajador trabajador);
	
	public Trabajador findById(Integer id);
	
	public void delete(Integer id);
}

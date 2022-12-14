package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;



public interface IEstacionamientoService {
	
	public List<Estacionamiento> findAll();
	
	public Estacionamiento save(Estacionamiento estacionamiento);
	
	public Estacionamiento findById(Integer id);
	
	public void delete(Integer id);

}
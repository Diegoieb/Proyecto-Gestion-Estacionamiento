package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;



public interface IVehiculoService {

	public List<Vehiculo> findAll();
	
	public Vehiculo save(Vehiculo vehiculo);
	
	public Vehiculo findById(Integer id);
	
	public void delete(Integer id);
}

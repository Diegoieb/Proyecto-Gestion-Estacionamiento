package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IEstacionamientoRepository;

@Service
public class EstacionamientoServicelmpl implements IEstacionamientoService{

	
	@Autowired
	IEstacionamientoRepository servicioEstacionamiento;
	
	@Override
	public List<Estacionamiento> findAll() {
		// TODO Auto-generated method stub
		return servicioEstacionamiento.findAll();
	}

	@Override
	public Estacionamiento save(Estacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		servicioEstacionamiento.save(estacionamiento);
		return null;
	}

	@Override
	public Estacionamiento findById(Integer id) {
		// TODO Auto-generated method stub
		servicioEstacionamiento.findById(id).orElse(null);
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		servicioEstacionamiento.deleteById(id);
	}

}
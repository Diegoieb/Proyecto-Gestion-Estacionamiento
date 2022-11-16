package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.ItrabajadorRepository;

@Service
public class TrabajadorServicelmpl implements ITrabajadorService{

	
	@Autowired
	ItrabajadorRepository trabajadorRepository;
	
	@Override
	public List<Trabajador> findAll() {
		// TODO Auto-generated method stub
		return trabajadorRepository.findAll();
	}

	@Override
	public Trabajador save(Trabajador trabajador) {
		// TODO Auto-generated method stub
		return trabajadorRepository.save(trabajador);
	}

	@Override
	public Trabajador findById(Integer id) {
		// TODO Auto-generated method stub
		return trabajadorRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		trabajadorRepository.deleteById(id);
		
	}



}

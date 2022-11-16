package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IservicioFleteRepository;

@Service
public class ServicioFletelmpl implements IServicioFlete{

	@Autowired
	IservicioFleteRepository servicioFleteRepository;
	
	@Override
	public List<ServicioFlete> findAll() {
		// TODO Auto-generated method stub
		return servicioFleteRepository.findAll();
	}

	@Override
	public ServicioFlete save(ServicioFlete ServicioFlete) {
		// TODO Auto-generated method stub
		return servicioFleteRepository.save(ServicioFlete);
	}

	@Override
	public ServicioFlete findById(Integer id) {
		// TODO Auto-generated method stub
		return servicioFleteRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		servicioFleteRepository.deleteById(id);
		
	}

}

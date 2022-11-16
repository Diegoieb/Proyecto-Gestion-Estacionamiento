package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioBanoRepository;

@Service
public class ServicioBanoServiceImpl implements IServicioBanoService{

	@Autowired
	IServicioBanoRepository servicioRepository;
	
	@Override
	public List<ServicioBano> findAll() {
		// TODO Auto-generated method stub
		return servicioRepository.findAll();
	}

	@Override
	public ServicioBano save(ServicioBano ServicioBano) {
		// TODO Auto-generated method stub
		return servicioRepository.save(ServicioBano);
	}

	@Override
	public ServicioBano findById(Integer id) {
		// TODO Auto-generated method stub
		return servicioRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		servicioRepository.deleteById(id);
		
	}

}

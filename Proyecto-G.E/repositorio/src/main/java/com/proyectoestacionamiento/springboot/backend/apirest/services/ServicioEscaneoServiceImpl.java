package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioEscaneo;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioEscaneoRepository;

@Service
public class ServicioEscaneoServiceImpl implements IServicioEscaneoService{

	@Autowired
	IServicioEscaneoRepository servicioRepository;
	
	
	@Override
	public List<ServicioEscaneo> findAll() {
		// TODO Auto-generated method stub
		return servicioRepository.findAll();
	}

	@Override
	public ServicioEscaneo save(ServicioEscaneo ServicioBano) {
		// TODO Auto-generated method stub
		return servicioRepository.save(ServicioBano);
	}

	@Override
	public ServicioEscaneo findById(Integer id) {
		// TODO Auto-generated method stub
		return servicioRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		servicioRepository.deleteById(id);
		
	}
	
	

}

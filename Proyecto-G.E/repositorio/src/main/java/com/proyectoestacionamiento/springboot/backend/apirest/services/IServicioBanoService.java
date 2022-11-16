package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;


public interface IServicioBanoService {
	
	public List<ServicioBano> findAll();
	
	public ServicioBano save(ServicioBano ServicioBano);
	
	public ServicioBano findById(Integer id);
	
	public void delete(Integer id);

}

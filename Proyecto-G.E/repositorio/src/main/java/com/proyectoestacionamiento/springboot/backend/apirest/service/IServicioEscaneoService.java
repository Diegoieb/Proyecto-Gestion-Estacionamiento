package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioEscaneo;


public interface IServicioEscaneoService {

	public List<ServicioEscaneo> findAll();
	
	public ServicioEscaneo save(ServicioEscaneo ServicioBano);
	
	public ServicioEscaneo findById(Integer id);
	
	public void delete(Integer id);
}

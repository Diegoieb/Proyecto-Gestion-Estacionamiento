package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IservicioVulcanizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicioVulcanizacionlmpl implements com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioVulcanizacionService {


	@Autowired
	IservicioVulcanizacionRepository servicioVulcanizacionRepository;

	@Override
	public List<ServicioVulcanizacion> findAll() {
		// TODO Auto-generated method stub
		return servicioVulcanizacionRepository.findAll();
	}

	@Override
	public ServicioVulcanizacion save(ServicioVulcanizacion ServicioVulcanizacion) {
		// TODO Auto-generated method stub
		return servicioVulcanizacionRepository.save(ServicioVulcanizacion);
	}

	@Override
	public ServicioVulcanizacion findById(Integer id) {
		// TODO Auto-generated method stub
		return servicioVulcanizacionRepository.findById(id).orElse(null);
	}

        @Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

		servicioVulcanizacionRepository.deleteById(id);

	}


}

package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioVulcanizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ServicioVulcanizacionlmpl implements com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioVulcanizacion {


	@Autowired
	IServicioVulcanizacionRepository servicioVulcanizacionRepository;

	public ServicioVulcanizacionlmpl(IServicioVulcanizacionRepository servicioVulcanizacionRepository) {
		this.servicioVulcanizacionRepository = servicioVulcanizacionRepository;
	}

	@Override
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		Map<String, Object> response = new HashMap<>();
		List<ServicioVulcanizacion> listaServicio;
		try {
			listaServicio = servicioVulcanizacionRepository.findAll();
			response.put("ok", true);
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("servicioVulcanizacion", listaServicio);
		return new ResponseEntity<>(response, HttpStatus.OK);
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

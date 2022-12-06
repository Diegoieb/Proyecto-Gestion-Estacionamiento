package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioFleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServicioFletelmpl implements IServicioFlete {

	@Autowired
	IServicioFleteRepository servicioFleteRepository;

	public ServicioFletelmpl(IServicioFleteRepository servicioFleteRepository) {
		this.servicioFleteRepository = servicioFleteRepository;
	}

	@Override
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		Map<String, Object> response = new HashMap<>();
		List<ServicioFlete> listaServicio;
		try {
			listaServicio = servicioFleteRepository.findAll();
			response.put("ok", true);
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("servicioFlete", listaServicio);
		return new ResponseEntity<>(response, HttpStatus.OK);
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

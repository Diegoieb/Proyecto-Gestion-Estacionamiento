package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioEscaneo;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioEscaneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServicioEscaneoServiceImpl implements IServicioEscaneoService {

	@Autowired
	IServicioEscaneoRepository servicioEscaneoRepository;

	public ServicioEscaneoServiceImpl(IServicioEscaneoRepository servicioEscaneoRepository) {
		this.servicioEscaneoRepository = servicioEscaneoRepository;
	}

	@Override
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		Map<String, Object> response = new HashMap<>();
		List<ServicioEscaneo> listaServicio;
		try {
			listaServicio = servicioEscaneoRepository.findAll();
			response.put("ok", true);
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("servicioEscaneo", listaServicio);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ServicioEscaneo save(ServicioEscaneo ServicioBano) {
		// TODO Auto-generated method stub
		return servicioEscaneoRepository.save(ServicioBano);
	}

	@Override
	public ServicioEscaneo findById(Integer id) {
		// TODO Auto-generated method stub
		return servicioEscaneoRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		servicioEscaneoRepository.deleteById(id);
		
	}
	
	

}

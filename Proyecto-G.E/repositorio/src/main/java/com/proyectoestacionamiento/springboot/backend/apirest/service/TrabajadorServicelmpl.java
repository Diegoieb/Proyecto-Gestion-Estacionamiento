package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.ITrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrabajadorServicelmpl implements ITrabajadorService {


	@Autowired
	ITrabajadorRepository trabajadorRepository;

	public TrabajadorServicelmpl(ITrabajadorRepository trabajadorRepository) {
		this.trabajadorRepository = trabajadorRepository;
	}

	@Override
	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<>();
		List<Trabajador> trabajador;
		try {
			trabajador = trabajadorRepository.findAll();
			response.put("ok", true);
		} catch (Exception e) {
			// TODO: handle exception
			response.put("Mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		response.put("trabajadores", trabajador);
		return new ResponseEntity<>(response, HttpStatus.OK);
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

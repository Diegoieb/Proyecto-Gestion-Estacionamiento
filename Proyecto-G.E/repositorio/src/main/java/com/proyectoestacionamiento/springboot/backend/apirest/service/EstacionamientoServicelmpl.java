package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IEstacionamientoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstacionamientoServicelmpl implements IEstacionamientoService{


	public EstacionamientoServicelmpl(IEstacionamientoRepository estacionamientoRepository) {
		this.estacionamientoRepository = estacionamientoRepository;
	}

	IEstacionamientoRepository estacionamientoRepository;
	
	@Override
	public ResponseEntity<Map<String, Object>> findAll() {
		Map<String,Object> response = new HashMap<>();
		List<Estacionamiento> listaEstacionamientos;
		try {
			listaEstacionamientos = estacionamientoRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("ok", true);
		response.put("estacionamientos", listaEstacionamientos);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public Estacionamiento save(Estacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		estacionamientoRepository.save(estacionamiento);
		return null;
	}

	@Override
	public Estacionamiento findById(Integer id) {
		// TODO Auto-generated method stub
		//falta el orElse(null)
		estacionamientoRepository.findById(id).orElse(null);
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		estacionamientoRepository.deleteById(id);
	}

}

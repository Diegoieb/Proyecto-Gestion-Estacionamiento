package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IEstacionamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EstacionamientoServiceImpl implements IEstacionamientoService{


	@Autowired
	IEstacionamientoRepository estacionamientoRepositorio;
	
	@Override
	public List<Estacionamiento> findAll() {
		// TODO Auto-generated method stub
		return estacionamientoRepositorio.findAll();
	}

	@Override
	public Estacionamiento save(Estacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		estacionamientoRepositorio.save(estacionamiento);
		return null;
	}

	@Override
	public Estacionamiento findById(Integer id) {
		// TODO Auto-generated method stub
		estacionamientoRepositorio.findById(id).orElse(null);
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		estacionamientoRepositorio.deleteById(id);
	}

	@Override
	public ResponseEntity<?> obtenerEstacionamientosDiscapacitados() {
		Map<String, Object> response = new HashMap<>();
		List<Estacionamiento> listaEstacionamientos = null;
		try {
			listaEstacionamientos = estacionamientoRepositorio.findAll();
			response.put("ok", true);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("Mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		List<Estacionamiento> estacionamientosDiscapacitados = listaEstacionamientos.stream().filter(estacionamiento -> estacionamiento.isDiscapacitado()).collect(Collectors.toList());
		response.put("estacionamientos", estacionamientosDiscapacitados);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
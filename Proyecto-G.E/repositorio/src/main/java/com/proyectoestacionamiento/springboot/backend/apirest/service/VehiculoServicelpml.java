package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehiculoServicelpml implements IVehiculoService {

	@Autowired
	IVehiculoRepository vehiculoRepository;

	public VehiculoServicelpml(IVehiculoRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}

	@Override
	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<>();
		List<Vehiculo> vehiculos;
		try {
			vehiculos = vehiculoRepository.findAll();
			response.put("ok", true);
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("vehiculos", vehiculos);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> save(Vehiculo vehiculo) {
		Map<String, Object> response = new HashMap<>();
		Vehiculo vehiculo2;
		try {
			vehiculo2 = vehiculoRepository.save(vehiculo);
			response.put("Ok", vehiculo2);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public Vehiculo findById(Integer id) {
		// TODO Auto-generated method stub
		return vehiculoRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehiculoRepository.deleteById(id);
		
	}
}

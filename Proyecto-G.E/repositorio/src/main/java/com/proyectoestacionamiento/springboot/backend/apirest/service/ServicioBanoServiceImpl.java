package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IBanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServicioBanoServiceImpl implements IServicioBanoService {

	@Autowired
	IBanoRepository banoRepository;

	public ServicioBanoServiceImpl(IBanoRepository banoRepository) {
		this.banoRepository = banoRepository;
	}

	@Override
	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<>();
		List<ServicioBano> listaBanos;
		try {
			listaBanos = banoRepository.findAll();
			response.put("ok", true);
		} catch (Exception e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("servicioBano", listaBanos);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ServicioBano save(ServicioBano ServicioBano) {
		// TODO Auto-generated method stub
		return banoRepository.save(ServicioBano);
	}

	@Override
	public ServicioBano findById(Integer id) {
		// TODO Auto-generated method stub
		return banoRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		banoRepository.deleteById(id);
		
	}

}

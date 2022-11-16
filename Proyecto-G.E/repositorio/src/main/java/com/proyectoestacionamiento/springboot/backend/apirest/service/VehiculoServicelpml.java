package com.proyectoestacionamiento.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IvehiculoRepository;

@Service
public class VehiculoServicelpml implements IVehiculoService{

	@Autowired
	IvehiculoRepository VehiculoRepository;

	@Override
	public List<Vehiculo> findAll() {
		// TODO Auto-generated method stub
		return VehiculoRepository.findAll();
	}

	@Override
	public Vehiculo save(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return VehiculoRepository.save(vehiculo);
	}

	@Override
	public Vehiculo findById(Integer id) {
		// TODO Auto-generated method stub
		return VehiculoRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		VehiculoRepository.deleteById(id);
		
	}
}

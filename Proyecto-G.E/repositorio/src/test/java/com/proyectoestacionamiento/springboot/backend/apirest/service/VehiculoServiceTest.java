package com.proyectoestacionamiento.springboot.backend.apirest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IvehiculoRepository;

@SpringBootTest
public class VehiculoServiceTest {

	@Mock
	IvehiculoRepository vehiculoRepository;
	
	@InjectMocks
	VehiculoServicelpml  vehiculoService;
	
	Vehiculo vehiculo1;
	Vehiculo vehiculo2;
	
	 @BeforeEach
	  void setup () {
		 vehiculo1 = new Vehiculo();
		 vehiculo2 = new Vehiculo();	 
	 }
	 
	 @Test
	 void findAllVehiculos() {
		// Given
		 //Creamos un array para guardar los vehiculos 
		 List<Vehiculo> vehiculos = new ArrayList<>();
		 
		 //Agregamos los vehiculos al array
		 vehiculos.add(vehiculo1);
		 vehiculos.add(vehiculo2);
		 when(vehiculoRepository.findAll()).thenReturn(vehiculos);
		 
		 //when
		 List<Vehiculo> vehiculosPrueba = vehiculoService.findAll();
		 
		 assertFalse(vehiculosPrueba.isEmpty());
	     assertEquals(2,vehiculosPrueba.size());
	     verify(vehiculoRepository).findAll();
	
	 }
}

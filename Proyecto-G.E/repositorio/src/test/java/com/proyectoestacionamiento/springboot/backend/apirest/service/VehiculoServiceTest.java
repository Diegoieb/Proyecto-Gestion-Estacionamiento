package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IvehiculoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
	 
		@Test
		void saveVehiculo() {
			Cliente cliente1 = new Cliente(1, "Gabriel",128718728 ,"Calle tu mama", "1111111-1",new HashSet<Vehiculo>());
			
			//given

			vehiculo1= new Vehiculo(1, "DL-DZ-31","rojo","chery", true,cliente1);
			when(vehiculoRepository.save(any())).then(invocation -> {
				Vehiculo a = invocation.getArgument(0);
				return a;
			});

			//when
			Vehiculo trabajadorPrueba = vehiculoService.save(vehiculo1);
			//then
			assertEquals(Long.valueOf(1), trabajadorPrueba.getId());
			assertEquals("DL-DZ-31", trabajadorPrueba.getPatente());

			verify(vehiculoRepository).save(any());
		}
        @Test
		void updateVehiculo() {
			Cliente cliente1 = new Cliente(1, "Gabriel",128718728 ,"Calle tu mama", "1111111-1",new HashSet<Vehiculo>());
			
			//given

			vehiculo1= new Vehiculo(1, "DL-DZ-31","rojo","chery", true,cliente1);
			when(vehiculoRepository.save(any())).then(invocation -> {
				Vehiculo a = invocation.getArgument(0);
				return a;
			});

			//when
			Vehiculo vehiculoPrueba = vehiculoService.save(vehiculo1);
                        
                        vehiculoPrueba.setPatente("AB-AB-AB");
			//then
			assertEquals(Long.valueOf(1), vehiculoPrueba.getId());
			assertEquals("AB-AB-AB", vehiculoPrueba.getPatente());

			verify(vehiculoRepository).save(any());
		}
}

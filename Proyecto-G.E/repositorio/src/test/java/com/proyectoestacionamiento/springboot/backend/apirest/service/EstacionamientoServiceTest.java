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


import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IEstacionamientoRepository;

@SpringBootTest
public class EstacionamientoServiceTest {
	
	@Mock
	IEstacionamientoRepository estacionamientoRepository;
	
	@InjectMocks
	EstacionamientoServiceImpl estacionamientoService;
	
	Estacionamiento estacionamiento1;
	Estacionamiento estacionamiento2;
	
	@BeforeEach
	void setup() {
		
		estacionamiento1 = new Estacionamiento();
		estacionamiento2 = new Estacionamiento();
	}
	
    @Test
    void findAllEstacionamientos() {
        // Given
        List<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
        estacionamientos.add(estacionamiento1);
        estacionamientos.add(estacionamiento2);
        when(estacionamientoRepository.findAll()).thenReturn(estacionamientos);

        //when
        List<Estacionamiento> estacionamientosPrueba = estacionamientoService.findAll();

        //then
        assertFalse(estacionamientosPrueba.isEmpty());
        assertEquals(2,estacionamientosPrueba.size());
        verify(estacionamientoRepository).findAll();
    }
	

}

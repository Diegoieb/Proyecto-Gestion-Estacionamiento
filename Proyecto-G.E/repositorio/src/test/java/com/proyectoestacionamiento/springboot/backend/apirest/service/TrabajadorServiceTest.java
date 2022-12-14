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


import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.ItrabajadorRepository;

@SpringBootTest
public class TrabajadorServiceTest {
	
	@Mock
	ItrabajadorRepository trabajadorRepository;
	
	@InjectMocks
	TrabajadorServicelmpl trabajadorService;
	
	Trabajador trabajador1;
	Trabajador trabajador2;
	
	@BeforeEach
	void setup() {
		
		trabajador1 = new Trabajador();
		
		trabajador2= new Trabajador();
	}
	
	@Test
    void findAllTrabajadores() {
        // Given
        List<Trabajador> trabajadores = new ArrayList<Trabajador>();
        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        when(trabajadorRepository.findAll()).thenReturn(trabajadores);

        //when
        List<Trabajador> trabajadorPrueba = trabajadorService.findAll();

        //then
        assertFalse(trabajadorPrueba.isEmpty());
        assertEquals(2,trabajadorPrueba.size());
        verify(trabajadorRepository).findAll();
    }

}

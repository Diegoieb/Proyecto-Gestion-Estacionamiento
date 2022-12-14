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

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioEscaneo;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioEscaneoRepository;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IservicioFleteRepository;







@SpringBootTest
public class ServicioFleteServiceTest {
	
	@Mock
    IservicioFleteRepository fleteRepository;


    @InjectMocks
    ServicioFletelmpl fleteService;

    ServicioFlete flete1;

    ServicioFlete flete2;

    @BeforeEach
    void setup () {

    	flete1 = new ServicioFlete ();
    	flete2 = new ServicioFlete ();

    }

    @Test
    void findAllFletes() {
        // Given
        List<ServicioFlete> fletes = new ArrayList<ServicioFlete>();
        fletes.add(flete1);
        fletes.add(flete2);
        when(fleteRepository.findAll()).thenReturn(fletes);

        //when
        List<ServicioFlete> fletesPrueba = fleteService.findAll();

        //then
        assertFalse(fletesPrueba.isEmpty());
        assertEquals(2,fletesPrueba.size());
        verify(fleteRepository).findAll();
    }

}

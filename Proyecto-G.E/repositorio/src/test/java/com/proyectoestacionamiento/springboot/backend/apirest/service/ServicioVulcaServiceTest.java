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
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioEscaneoRepository;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IservicioVulcanizacionRepository;


@SpringBootTest
public class ServicioVulcaServiceTest {
	
	
	@Mock
    IservicioVulcanizacionRepository vulcaRepository;


    @InjectMocks
    ServicioVulcanizacionlmpl vulcaService;

    ServicioVulcanizacion vulca1;

    ServicioVulcanizacion vulca2;

    @BeforeEach
    void setup () {

    	vulca1 = new ServicioVulcanizacion ();
    	vulca2 = new ServicioVulcanizacion ();

    }

    @Test
    void findAllVulcanizacion() {
        // Given
        List<ServicioVulcanizacion> vulcas = new ArrayList<ServicioVulcanizacion>();
        vulcas.add(vulca1);
        vulcas.add(vulca2);
        when(vulcaRepository.findAll()).thenReturn(vulcas);

        //when
        List<ServicioVulcanizacion> vulcasPrueba = vulcaService.findAll();

        //then
        assertFalse(vulcasPrueba.isEmpty());
        assertEquals(2,vulcasPrueba.size());
        verify(vulcaRepository).findAll();
    }

}
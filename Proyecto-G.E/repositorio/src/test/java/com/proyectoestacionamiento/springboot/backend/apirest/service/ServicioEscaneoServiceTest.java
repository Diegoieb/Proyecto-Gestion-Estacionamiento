package com.proyectoestacionamiento.springboot.backend.apirest.service;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
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
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioEscaneoRepository;





@SpringBootTest
public class ServicioEscaneoServiceTest {
	
	
	@Mock
    IServicioEscaneoRepository escaneoRepository;


    @InjectMocks
    ServicioEscaneoServiceImpl escaneoService;

    ServicioEscaneo escaneo1;

    ServicioEscaneo escaneo2;

    @BeforeEach
    void setup () {

    	escaneo1 = new ServicioEscaneo ();
    	escaneo2 = new ServicioEscaneo ();

    }

    @Test
    void findAllEscaneos() {
        // Given
        List<ServicioEscaneo> escaneos = new ArrayList<ServicioEscaneo>();
        escaneos.add(escaneo1);
        escaneos.add(escaneo2);
        when(escaneoRepository.findAll()).thenReturn(escaneos);

        //when
        List<ServicioEscaneo> escaneosPrueba = escaneoService.findAll();

        //then
        assertFalse(escaneosPrueba.isEmpty());
        assertEquals(2,escaneosPrueba.size());
        verify(escaneoRepository).findAll();
    }
    
    @Test
    void DeleleVehiculorTest() {
        doNothing().when(escaneoRepository).deleteById(any());
        escaneoService.delete(valueOf(1));
        verify(escaneoRepository).deleteById(any());
    }

}

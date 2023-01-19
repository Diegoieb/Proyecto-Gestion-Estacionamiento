package com.proyectoestacionamiento.springboot.backend.apirest.service;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.*;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IservicioVulcanizacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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
    
    @Test
    void saveVulca() {

        //given

        ServicioVulcanizacion service = new ServicioVulcanizacion(12, false, 190, new Estacionamiento(6, false, 2, 34, null), new Trabajador());
        when(vulcaRepository.save(any())).then(invocation -> {
            ServicioVulcanizacion a = invocation.getArgument(0);

            a.setId(12);
            return a;
        });

        //when
        ServicioVulcanizacion vulcaPrueba = vulcaService.save(service);
        //then
        assertEquals(12, vulcaPrueba.getId());
        assertEquals(190, vulcaPrueba.getPrecio());

        verify(vulcaRepository).save(any());
    }


    @Test
    void modifyVulca() {

        //given
        ServicioVulcanizacion service = new ServicioVulcanizacion(12, false, 190, new Estacionamiento(6, false, 2, 34, null), new Trabajador());
        when(vulcaRepository.save(any())).then(invocation -> {
            ServicioVulcanizacion a = invocation.getArgument(0);

            a.setId(12);
            return a;
        });
        //when
        ServicioVulcanizacion vulcaPrueba = vulcaService.save(service);
        vulcaPrueba.setId(10);
        //then
        assertEquals(10, vulcaPrueba.getId());
        assertEquals(190, vulcaPrueba.getPrecio());
        verify(vulcaRepository).save(any());
    }


    @Test
    void DeleleVulcaTest() {
        doNothing().when(vulcaRepository).deleteById(any());
        vulcaService.delete(valueOf(1));
        verify(vulcaRepository).deleteById(any());
    }

}
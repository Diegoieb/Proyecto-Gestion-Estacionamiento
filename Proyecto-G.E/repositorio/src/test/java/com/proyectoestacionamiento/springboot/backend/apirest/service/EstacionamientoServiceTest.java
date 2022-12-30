package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IEstacionamientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        assertEquals(2, estacionamientosPrueba.size());
        verify(estacionamientoRepository).findAll();
    }

    @Test
    public void testObtenerEstacionamientosDiscapacitados() {
        // GIVEN
        List<Estacionamiento> listaEstacionamientos = new ArrayList<>();
        listaEstacionamientos.add(new Estacionamiento(1, true, 30, 100));
        listaEstacionamientos.add(new Estacionamiento(2, false, 31, 100));
        listaEstacionamientos.add(new Estacionamiento(3, true, 32, 100));
        listaEstacionamientos.add(new Estacionamiento(4, false, 33, 100));
        listaEstacionamientos.add(new Estacionamiento(5, true, 34, 100));
        when(estacionamientoRepository.findAll()).thenReturn(listaEstacionamientos);

        // WHEN
        ResponseEntity<?> response = estacionamientoService.obtenerEstacionamientosDiscapacitados();

        // THEN
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
        assertEquals(true, responseBody.get("ok"));
        List<Estacionamiento> estacionamientosDiscapacitados = (List<Estacionamiento>) responseBody.get("estacionamientos");
        assertEquals(3, estacionamientosDiscapacitados.size());
        assertEquals(true, estacionamientosDiscapacitados.get(0).isDiscapacitado());
        assertEquals(true, estacionamientosDiscapacitados.get(1).isDiscapacitado());
        assertEquals(true, estacionamientosDiscapacitados.get(2).isDiscapacitado());
    }
}

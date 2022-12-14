package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IEstacionamientoService;

//para hacer las llamadas http
@WebMvcTest(EstacionamientoResController.class)
public class EstacionamientoControllerTest {
	

	
	@Autowired
	private MockMvc mvc;
	
	//para simular la respuesta http
	@MockBean
	private IEstacionamientoService estacionamientoService;
	
	Estacionamiento estacionamiento1;
	Estacionamiento estacionamiento2;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		estacionamiento1= new Estacionamiento(1,true,100,23);
		estacionamiento2= new Estacionamiento(2,true,10,15);
		//para cuando quieres escribir en el json
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void indexTest() throws Exception {
		// given
		List<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
		estacionamientos.add(estacionamiento1);
		estacionamientos.add(estacionamiento2);
		when(estacionamientoService.findAll()).thenReturn(estacionamientos);
		
		// when
		mvc.perform(get("/apiEstacionamiento/estacionamientos").contentType(MediaType.APPLICATION_JSON))
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ok").value(true))
		.andExpect(jsonPath("$.estacionamientos").isNotEmpty());
		
		verify(estacionamientoService).findAll();
	}
	
	@Test
    void indexTestNoValido() throws Exception {
        // given

        when(estacionamientoService.findAll()).thenThrow(new DataAccessException("...") {});

        // when
        mvc.perform(get("/apiEstacionamiento/estacionamientos").contentType(MediaType.APPLICATION_JSON))
        //then
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.ok").value(false))
        .andExpect(jsonPath("$.Mensaje").value("Error al realizar la consulta en la base de datos"));

        verify(estacionamientoService).findAll();
    }
	
	
}
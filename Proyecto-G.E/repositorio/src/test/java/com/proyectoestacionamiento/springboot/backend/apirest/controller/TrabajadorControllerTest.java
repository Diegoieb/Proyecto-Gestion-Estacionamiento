package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.service.ITrabajadorService;

//para hacer las llamadas http
@WebMvcTest(TrabajadorRestController.class)
public class TrabajadorControllerTest {

	
	@Autowired
	private MockMvc mvc;
	
	//para simular la respuesta http
	@MockBean
	private ITrabajadorService trabajadorService;
	
	Trabajador trabajador1;
	Trabajador trabajador2;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		trabajador1= new Trabajador(1L, "Esteban",128718728 ,"Calle tu mama", "1111111-1");
		trabajador2= new Trabajador(2L, "Pedro",129182991, "Calle tu papa", "6666666-6");
		//para cuando quieres escribir en el json
		objectMapper = new ObjectMapper();
	}
	
	//findAll()
	@Test
	void indexTest() throws Exception {
		// given
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores.add(trabajador1);
		trabajadores.add(trabajador2);
		when(trabajadorService.findAll()).thenReturn(trabajadores);
		
		// when
		mvc.perform(get("/apiEstacionamiento/trabajadores").contentType(MediaType.APPLICATION_JSON))
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ok").value(true))
		.andExpect(jsonPath("$.trabajadores").isNotEmpty());
		
		verify(trabajadorService).findAll();
	}
	
	@Test
    void indexTestNoValido() throws Exception {
        // given

        when(trabajadorService.findAll()).thenThrow(new DataAccessException("...") {});

        // when
        mvc.perform(get("/apiEstacionamiento/trabajadores").contentType(MediaType.APPLICATION_JSON))
        //then
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.ok").value(false))
        .andExpect(jsonPath("$.Mensaje").value("Error al realizar la consulta en la base de datos"));

        verify(trabajadorService).findAll();
    }

	
	//save()
	@Test
	void createTrabajadorTest() throws  Exception {

		//Given
		Trabajador alguien = new Trabajador(1l, "Esteban", 56949590,  "Padorulandia","19.414.677-7");
		when(trabajadorService.save(any())).thenReturn(alguien);


		//When
		mvc.perform(post("/apiEstacionamiento/trabajadores")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(alguien)))

				//then
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.trabajador.nombre").value("Esteban"));

	}
	@Test
	void createTrabajadorTestNoValido() throws  Exception {

		//Given
		Trabajador alguien = new Trabajador(1l, "Mateo", 569495690,  "Padorulandia","19.414.677-7");


		//When
		when(trabajadorService.save(any())).thenThrow(new DataAccessException("...") {});
		mvc.perform(post("/apiEstacionamiento/trabajadores")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(alguien)))

		
				//then
				.andExpect(status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

}
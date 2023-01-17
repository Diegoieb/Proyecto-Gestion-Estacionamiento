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
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IEstacionamientoService;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioVulcanizacionService;

//para hacer las llamadas http
@WebMvcTest(ServicioVulcanizacionRestController.class)
public class ServicioVulcaControllerTest {


	
	@Autowired
	private MockMvc mvc;
	
	//para simular la respuesta http
	@MockBean
	private IServicioVulcanizacionService vulcanizacionService;
	
	
	ServicioVulcanizacion vulcanizacion1;

	ServicioVulcanizacion vulcanizacion2;
	
	Trabajador trabajador1;
	
	Estacionamiento estacionamiento1;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		trabajador1= new Trabajador(1, "Esteban",128718728 ,"Calle tu mama", "1111111-1");
		estacionamiento1= new Estacionamiento(1,true,100,23);
		vulcanizacion1= new ServicioVulcanizacion(1l,true,1000,estacionamiento1,trabajador1);
		vulcanizacion2= new ServicioVulcanizacion(2l,false,100,estacionamiento1,trabajador1);
		//para cuando quieres escribir en el json
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void indexTest() throws Exception {
		// given
		List<ServicioVulcanizacion> vulcanizaciones = new ArrayList<ServicioVulcanizacion>();
		vulcanizaciones.add(vulcanizacion1);
		vulcanizaciones.add(vulcanizacion2);
		when(vulcanizacionService.findAll()).thenReturn(vulcanizaciones);
		
		// when
		mvc.perform(get("/apiEstacionamiento/servioVulcanizacion").contentType(MediaType.APPLICATION_JSON))
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ok").value(true))
		.andExpect(jsonPath("$.servicioVulcanizacion").isNotEmpty());
		
		verify(vulcanizacionService).findAll();
	}
	
	@Test
    void indexTestNoValido() throws Exception {
        // given

        when(vulcanizacionService.findAll()).thenThrow(new DataAccessException("...") {});

        // when
        mvc.perform(get("/apiEstacionamiento/servioVulcanizacion").contentType(MediaType.APPLICATION_JSON))
        //then
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.ok").value(false))
        .andExpect(jsonPath("$.Mensaje").value("Error al realizar la consulta en la base de datos"));

        verify(vulcanizacionService).findAll();
    }


	@Test
	void createVulcaTest() throws  Exception {

		//Given

		when(vulcanizacionService.save(any())).thenReturn(vulcanizacion1);

		//When
		mvc.perform(post("/apiEstacionamiento/servioVulcanizacion")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(vulcanizacion1)))

				//then
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	@Test
	void createVulcaTestNoValido() throws  Exception {

		//Given

		//When
		when(vulcanizacionService.save(any())).thenThrow(new DataAccessException("...") {});
		mvc.perform(post("/apiEstacionamiento/servioVulcanizacion")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(vulcanizacion1)))
				//then
				.andExpect(status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	
}
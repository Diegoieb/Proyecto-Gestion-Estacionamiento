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
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioEscaneo;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioBanoService;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioEscaneoService;



//para hacer las llamadas http
@WebMvcTest(ServicioBanoRestController.class)
public class ServicioBanoControllerTest {


	
	@Autowired
	private MockMvc mvc;
	
	//para simular la respuesta http
	@MockBean
	private IServicioBanoService banoService;
	
	
	ServicioBano bano1;

	ServicioBano bano2;
	
	Trabajador trabajador1;
	
	Estacionamiento estacionamiento1;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		trabajador1= new Trabajador(1L, "Esteban",128718728 ,"Calle tu mama", "1111111-1");
		
		estacionamiento1= new Estacionamiento(1,true,100,23);
		
		bano1= new ServicioBano(1l,true,estacionamiento1,trabajador1);
		bano2= new ServicioBano(2l,false,estacionamiento1,trabajador1);
		//para cuando quieres escribir en el json
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void indexTest() throws Exception {
		// given
		List<ServicioBano> escaneos = new ArrayList<ServicioBano>();
		escaneos.add(bano1);
		escaneos.add(bano2);
		when(banoService.findAll()).thenReturn(escaneos);
		
		// when
		mvc.perform(get("/apiEstacionamiento/servicioBano").contentType(MediaType.APPLICATION_JSON))
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ok").value(true))
		.andExpect(jsonPath("$.servicioBano").isNotEmpty());
		
		verify(banoService).findAll();
	}
	
	@Test
    void indexTestNoValido() throws Exception {
        // given

        when(banoService.findAll()).thenThrow(new DataAccessException("...") {});

        // when
        mvc.perform(get("/apiEstacionamiento/servicioBano").contentType(MediaType.APPLICATION_JSON))
        //then
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.ok").value(false))
        .andExpect(jsonPath("$.Mensaje").value("Error al realizar la consulta en la base de datos"));

        verify(banoService).findAll();
    }
	
	
}

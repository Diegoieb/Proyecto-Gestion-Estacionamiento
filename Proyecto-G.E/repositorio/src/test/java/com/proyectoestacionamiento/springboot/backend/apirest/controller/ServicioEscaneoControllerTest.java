package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioEscaneo;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioEscaneoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



//para hacer las llamadas http
@WebMvcTest(ServicioEscaneoRestController.class)
public class ServicioEscaneoControllerTest {


	
	@Autowired
	private MockMvc mvc;
	
	//para simular la respuesta http
	@MockBean
	private IServicioEscaneoService escaneoService;
	
	
	ServicioEscaneo escaneo1;

	ServicioEscaneo escaneo2;
	
	Trabajador trabajador1;
	
	Estacionamiento estacionamiento1;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		trabajador1 = new Trabajador(1, "Esteban", 128718728, "Calle tu mama", "1111111-1");
		
		estacionamiento1 = new Estacionamiento(1, true, 100, 23, null);

		escaneo1 = new ServicioEscaneo(1, true, 1000, estacionamiento1, trabajador1);
		escaneo2 = new ServicioEscaneo(2, false, 100, estacionamiento1, trabajador1);
		//para cuando quieres escribir en el json
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void indexTest() throws Exception {
		// given
		List<ServicioEscaneo> escaneos = new ArrayList<ServicioEscaneo>();
		escaneos.add(escaneo1);
		escaneos.add(escaneo2);
		when(escaneoService.findAll()).thenReturn(escaneos);
		
		// when
		mvc.perform(get("/apiEstacionamiento/servicioEscaneo").contentType(MediaType.APPLICATION_JSON))
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ok").value(true))
		.andExpect(jsonPath("$.servicioEscaneo").isNotEmpty());
		
		verify(escaneoService).findAll();
	}
	
	@Test
    void indexTestNoValido() throws Exception {
        // given

        when(escaneoService.findAll()).thenThrow(new DataAccessException("...") {});

        // when
        mvc.perform(get("/apiEstacionamiento/servicioEscaneo").contentType(MediaType.APPLICATION_JSON))
        //then
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.ok").value(false))
        .andExpect(jsonPath("$.Mensaje").value("Error al realizar la consulta en la base de datos"));

        verify(escaneoService).findAll();
    }
	
	@Test
	void deleteTrabajadorTest() throws Exception {

		//Given
		doNothing().when(escaneoService).delete(any());

		//when
		mvc.perform(delete("/apiEstacionamiento/servicioEscaneo/1")
						.contentType(MediaType.APPLICATION_JSON))
				//then
				.andExpect(status().isOk());
	}
	
	
}

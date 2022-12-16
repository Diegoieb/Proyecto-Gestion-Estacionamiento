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
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IClienteService;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IVehiculoService;


//para hacer las llamadas http
@WebMvcTest(VehiculoRestController.class)
public class VehiculoControllerTest {

	
	@Autowired
	private MockMvc mvc;
	
	//para simular la respuesta http
	@MockBean
	private IVehiculoService vehiculoService;
	
	Vehiculo vehiculo1;
	Vehiculo vehiculo2;
	Cliente cliente1;
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		cliente1= new Cliente(1L, "Gabriel",128718728 ,"Calle tu mama", "1111111-1",new HashSet<Vehiculo>());
		vehiculo1= new Vehiculo(1, "DL-DZ-31","rojo","chery", true,cliente1);
		vehiculo2= new Vehiculo(1, "DL-DZ-32","azul","azurian", false,cliente1);

		//para cuando quieres escribir en el json
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void indexTest() throws Exception {
		// given
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		vehiculos.add(vehiculo1);
		vehiculos.add(vehiculo2);
		when(vehiculoService.findAll()).thenReturn(vehiculos);
		
		// when
		mvc.perform(get("/apiEstacionamiento/vehiculos").contentType(MediaType.APPLICATION_JSON))
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ok").value(true))
		.andExpect(jsonPath("$.vehiculos").isNotEmpty());
		
		verify(vehiculoService).findAll();
	}
	
	@Test
    void indexTestNoValido() throws Exception {
        // given

        when(vehiculoService.findAll()).thenThrow(new DataAccessException("...") {});

        // when
        mvc.perform(get("/apiEstacionamiento/vehiculos").contentType(MediaType.APPLICATION_JSON))
        //then
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.ok").value(false))
        .andExpect(jsonPath("$.Mensaje").value("Error al realizar la consulta en la base de datos"));

        verify(vehiculoService).findAll();
    }
	
	
	//save()

	@Test
	void createVehiculoTest() throws  Exception {

		//Given
		
		when(vehiculoService.save(any())).thenReturn(vehiculo1);

		//When
		mvc.perform(post("/apiEstacionamiento/vehiculos")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(vehiculo1)))

				//then
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.vehiculo.patente").value("DL-DZ-31"));
	
	}
	@Test
	void createClienteTestNoValido() throws  Exception {

		//Given
		
		//When
		when(vehiculoService.save(any())).thenThrow(new DataAccessException("...") {});
		mvc.perform(post("/apiEstacionamiento/vehiculos")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(vehiculo1)))
				//then
				.andExpect(status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
}
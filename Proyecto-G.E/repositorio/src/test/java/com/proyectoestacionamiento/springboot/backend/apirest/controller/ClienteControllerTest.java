package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import static java.lang.Integer.valueOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IClienteService;

//para hacer las llamadas http
@WebMvcTest(ClienteRestController.class)
public class ClienteControllerTest {

	
	@Autowired
	private MockMvc mvc;
	
	//para simular la respuesta http
	@MockBean
	private IClienteService clienteService;
	
	Cliente cliente1;
	Cliente cliente2;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		cliente1= new Cliente(1, "Esteban",128718728 ,"Calle tu mama", "1111111-1",new HashSet<Vehiculo>());
		cliente2= new Cliente(2, "Giovanni",129182991, "Calle tu papa", "6666666-6",new HashSet<Vehiculo>());
		//para cuando quieres escribir en el json
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void indexTest() throws Exception {
		// given
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		when(clienteService.findAll()).thenReturn(clientes);
		
		// when
		mvc.perform(get("/apiEstacionamiento/clientes").contentType(MediaType.APPLICATION_JSON))
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ok").value(true))
		.andExpect(jsonPath("$.clientes").isNotEmpty());
		
		verify(clienteService).findAll();
	}
	
	@Test
    void indexTestNoValido() throws Exception {
        // given

        when(clienteService.findAll()).thenThrow(new DataAccessException("...") {});

        // when
        mvc.perform(get("/apiEstacionamiento/clientes").contentType(MediaType.APPLICATION_JSON))
        //then
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.ok").value(false))
        .andExpect(jsonPath("$.Mensaje").value("Error al realizar la consulta en la base de datos"));

        verify(clienteService).findAll();
    }
	
	//save()
	@Test
	void createClienteTest() throws  Exception {

		//Given

		when(clienteService.save(any())).thenReturn(cliente1);

		//When
		mvc.perform(post("/apiEstacionamiento/clientes")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(cliente1)))

				//then
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));


	}
	@Test
	void createClienteTestNoValido() throws  Exception {

		//Given
		
		//When
		when(clienteService.save(any())).thenThrow(new DataAccessException("...") {});
		mvc.perform(post("/apiEstacionamiento/clientes")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(cliente1)))
				//then
				.andExpect(status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void deleteClienteTest() throws Exception {

		//Given
		doNothing().when(clienteService).delete(any());

		//when
		mvc.perform(delete("/apiEstacionamiento/clientes/1")
						.contentType(MediaType.APPLICATION_JSON))
				//then
				.andExpect(status().isOk());
	}

}
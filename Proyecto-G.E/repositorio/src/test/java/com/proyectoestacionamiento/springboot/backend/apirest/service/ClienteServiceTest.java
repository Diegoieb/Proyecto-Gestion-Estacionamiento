package com.proyectoestacionamiento.springboot.backend.apirest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IclienteRepository;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    IclienteRepository clienteRepository;


    @InjectMocks
    ClienteServiceImpl clienteService;

    Cliente cliente1;

    Cliente cliente2;

    @BeforeEach
    void setup () {

        cliente1 = new Cliente ();
        cliente2 = new Cliente ();

    }

    @Test
    void findAllClientes() {
        // Given
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        when(clienteRepository.findAll()).thenReturn(clientes);

        //when
        List<Cliente> clientesPrueba = clienteService.findAll();

        //then
        assertFalse(clientesPrueba.isEmpty());
        assertEquals(2,clientesPrueba.size());
        verify(clienteRepository).findAll();
    }
    
	@Test
	void saveCliente() {

		//given

		Cliente alguien = new Cliente(1l, "Mateo", 569496790,"Padorulandia","19.414.677-7",new HashSet<Vehiculo>());
		when(clienteRepository.save(any())).then(invocation -> {
			Cliente a = invocation.getArgument(0);

			a.setId(Long.valueOf(3));
			return a;
		});

		//when
		Cliente trabajadorPrueba = clienteService.save(alguien);
		//then
		assertEquals(Long.valueOf(3), trabajadorPrueba.getId());
		assertEquals("Mateo", trabajadorPrueba.getNombre());

		verify(clienteRepository).save(any());
	}


}
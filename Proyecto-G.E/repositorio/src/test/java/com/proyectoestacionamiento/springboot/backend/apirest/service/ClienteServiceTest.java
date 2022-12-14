package com.proyectoestacionamiento.springboot.backend.apirest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
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


}
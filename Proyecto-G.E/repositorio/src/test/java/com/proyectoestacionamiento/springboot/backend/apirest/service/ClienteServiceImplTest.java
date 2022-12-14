package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IEstacionamientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClienteServiceImplTest {

    private ClienteServiceImpl clienteService;
    @Mock
    private IclienteRepository clienteRepository;


    @BeforeEach
    void setUp() {
        clienteRepository = mock(IEstacionamientoRepository.class);
        clienteService= new ClienteServiceImpl(clienteRepository);
    }

    @DisplayName("Si hay clientes, el metodo findAll retorna OK y los datos")
    @Test
    void findAllRetornaOKConDatos() {
        //Arrange
        List<Cliente> listaClientes = new ArrayList<>();
        /*
        Se puede utilizar el constructor vacio y usar los set para asignar las propiedades,
        o bien se puede utilizar el constructor con parametros asignando las propiedades
        en ese momento.
         */
        Vehiculo vehiculo = new Vehiculo (1,"AR6060","Rojo","Toyota",true,null);
        Set<Vehiculo> vehiculosTest = new Set<Vehiculo>();
        vehiculosTest.add(vehiculo);
        Cliente cliente = new Cliente(1,"Carlos",569454545,"Avenida Algo 693","19.414.666-6",vehiculosTest);
        vehiculo.setCliente(cliente);
        listaClientes.add(cliente);
        when(clienteRepository.findAll()).thenReturn(listaClientes);
        //Act
        ResponseEntity<Map<String, Object>> respuestaServicio = clienteService.findAll();
        //Assert
        assertEquals(HttpStatus.OK,respuestaServicio.getStatusCode());
        assertEquals(2,respuestaServicio.getBody().size());
    }

    @DisplayName("Si hay un error en la conexion con la base de datos, se retorna not found")
    @Test
    void findAllRetornaNotFoundSiHayUnError() {
        //Arrange
        when(clienteRepository.findAll()).thenThrow(new RuntimeException());
        //Act
        ResponseEntity<Map<String, Object>> respuestaServicio = clienteService.findAll();
        //Assert
        assertEquals(HttpStatus.NOT_FOUND,respuestaServicio.getStatusCode());
    }
}
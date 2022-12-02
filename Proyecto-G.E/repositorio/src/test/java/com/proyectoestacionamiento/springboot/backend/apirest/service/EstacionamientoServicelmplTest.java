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

class EstacionamientoServicelmplTest {

    private EstacionamientoServicelmpl estacionamientoService;
    @Mock
    private IEstacionamientoRepository estacionamientoRepository;


    @BeforeEach
    void setUp() {
        estacionamientoRepository = mock(IEstacionamientoRepository.class);
        estacionamientoService= new EstacionamientoServicelmpl(estacionamientoRepository);
    }

    @DisplayName("Si hay estacionamientos, el metodo findAll retorna OK y los datos")
    @Test
    void findAllRetornaOKConDatos() {
        //Arrange
        List<Estacionamiento> listaEstacionamientos = new ArrayList<>();
        /*
        Se puede utilizar el constructor vacio y usar los set para asignar las propiedades,
        o bien se puede utilizar el constructor con parametros asignando las propiedades
        en ese momento.
         */
        Estacionamiento estacionamiento = new Estacionamiento();
        estacionamiento.setIdEstacionamiento(1);
        estacionamiento.setDiscapacitado(false);
        estacionamiento.setCantidad(5);
        estacionamiento.setPrecioPorMinuto(50);
        listaEstacionamientos.add(estacionamiento);
        when(estacionamientoRepository.findAll()).thenReturn(listaEstacionamientos);
        //Act
        ResponseEntity<Map<String, Object>> respuestaServicio = estacionamientoService.findAll();
        //Assert
        assertEquals(HttpStatus.OK,respuestaServicio.getStatusCode());
        assertEquals(2,respuestaServicio.getBody().size());
    }

    @DisplayName("Si hay un error en la conexion con la base de datos, se retorna not found")
    @Test
    void findAllRetornaNotFoundSiHayUnError() {
        //Arrange
        when(estacionamientoRepository.findAll()).thenThrow(new RuntimeException());
        //Act
        ResponseEntity<Map<String, Object>> respuestaServicio = estacionamientoService.findAll();
        //Assert
        assertEquals(HttpStatus.NOT_FOUND,respuestaServicio.getStatusCode());
    }
}
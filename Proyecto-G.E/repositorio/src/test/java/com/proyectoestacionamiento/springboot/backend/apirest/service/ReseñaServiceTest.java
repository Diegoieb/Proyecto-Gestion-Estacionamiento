package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Reseña;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.models.rest.ReseñaRespuesta;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IReseñaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReseñaServiceTest {

    @Mock
    IReseñaRepository reseñaRepository;

    @InjectMocks
    ReseñaServiceImpl reseñaService;

    Cliente cliente1 = new Cliente(1, "Mateo", 569496790, "Padorulandia", "19.414.677-7", new HashSet<Vehiculo>());
    Cliente cliente2 = new Cliente(2, "Ana", 569123345, "Padorulandia2", "19.414.677-8", new HashSet<Vehiculo>());
    Estacionamiento estacionamiento = new Estacionamiento(1, true, 15, 100, null);

    Reseña reseña = new Reseña("contenido", cliente1, estacionamiento);

    @Test
    void obtenerTodasLasReseñas() {
        ArrayList<Reseña> list = new ArrayList<>();
        list.add(new Reseña("contenido", cliente1, estacionamiento));
        list.add(new Reseña("contenido2", cliente2, estacionamiento));
        when(reseñaRepository.findAll()).thenReturn(list);

        List<ReseñaRespuesta> reseñaRespuestas = reseñaService.obtenerTodasLasReseñas();

        assertNotNull(reseñaRespuestas);
        assertEquals(2, reseñaRespuestas.size());
        assertEquals("Mateo", reseñaRespuestas.get(0).getNombreCliente());
        assertEquals(1, reseñaRespuestas.get(0).getIdEstacionamiento());
        assertEquals("Ana", reseñaRespuestas.get(1).getNombreCliente());
        assertEquals(1, reseñaRespuestas.get(1).getIdEstacionamiento());
    }

    @Test
    void crearReseña() {

        when(reseñaRepository.save(any())).thenReturn(reseña);

        ReseñaRespuesta reseñaRespuesta = reseñaService.crearReseña(reseña);

        assertNotNull(reseñaRespuesta);
        assertEquals(reseña.getCliente().getNombre(), reseñaRespuesta.getNombreCliente());
        assertEquals(reseña.getEstacionamiento().getIdEstacionamiento(), reseñaRespuesta.getIdEstacionamiento());
    }

    @Test
    void encontrarReseñaPorId() {
        when(reseñaRepository.findById(any())).thenReturn(Optional.ofNullable(reseña));

        ReseñaRespuesta reseñaRespuesta = null;
        try {
            reseñaRespuesta = reseñaService.encontrarReseñaPorId(reseña.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertNotNull(reseñaRespuesta);
        assertEquals(reseña.getCliente().getNombre(), reseñaRespuesta.getNombreCliente());
        assertEquals(reseña.getEstacionamiento().getIdEstacionamiento(), reseñaRespuesta.getIdEstacionamiento());
    }

    @Test
    void borrarReseñaPorId() {
        reseñaService.borrarReseñaPorId(reseña.getId());
        verify(reseñaRepository).deleteById(any());
    }


}

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

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IServicioBanoRepository;



@SpringBootTest
public class ServicioBanoServiceTest {
	
	@Mock
    IServicioBanoRepository banoRepository;


    @InjectMocks
    ServicioBanoServiceImpl banoService;

    ServicioBano bano1;

    ServicioBano bano2;

    @BeforeEach
    void setup () {

        bano1 = new ServicioBano ();
        bano2 = new ServicioBano ();

    }

    @Test
    void findAllBanos() {
        // Given
        List<ServicioBano> banos = new ArrayList<ServicioBano>();
        banos.add(bano1);
        banos.add(bano2);
        when(banoRepository.findAll()).thenReturn(banos);

        //when
        List<ServicioBano> banosPrueba = banoService.findAll();

        //then
        assertFalse(banosPrueba.isEmpty());
        assertEquals(2,banosPrueba.size());
        verify(banoRepository).findAll();
    }

}

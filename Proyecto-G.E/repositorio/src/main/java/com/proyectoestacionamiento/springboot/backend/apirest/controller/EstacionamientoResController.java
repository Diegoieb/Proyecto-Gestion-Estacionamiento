package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Estacionamiento;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioBano;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IEstacionamientoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class EstacionamientoResController {

    @Autowired
    IEstacionamientoService estacionamiento;

    @GetMapping("/estacionamientos")
    public ResponseEntity<?> index(){
        Map<String,Object> response = new HashMap<>();
        List<Estacionamiento> ListaEstacionamientos = null;
        try {
            ListaEstacionamientos = estacionamiento.findAll();
            response.put("ok", true);
        } catch (DataAccessException e) {
            // TODO: handle exception
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            response.put("ok", false);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        response.put("estacionamientos", ListaEstacionamientos);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

    }

}
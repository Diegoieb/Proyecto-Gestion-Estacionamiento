package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioVulcanizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class ServicioVulcanizacionResController {

    @Autowired
    IServicioVulcanizacion servicioVulcanizacion;

    @GetMapping("/servioVulcanizacion")
    public ResponseEntity<?> index() {
        return servicioVulcanizacion.findAll();
    }
}
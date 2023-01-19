package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Reseña;
import com.proyectoestacionamiento.springboot.backend.apirest.models.rest.ReseñaRespuesta;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento/reseña")
public class ReseñaRestController {

    @Autowired
    IReseñaService reseñaService;


    //CRUD
    //Create
    @PostMapping("")
    public ReseñaRespuesta crearReseña(@RequestBody Reseña reseña) {
        return reseñaService.crearReseña(reseña);

    }

    //Read
    @GetMapping()
    public List<ReseñaRespuesta> obtenerTodasLasReseñas() {
        return reseñaService.obtenerTodasLasReseñas();
    }

    @GetMapping("/{id}")
    public ReseñaRespuesta obtenerReseñaPorId(@PathVariable int id) throws Exception {
        return reseñaService.encontrarReseñaPorId(id);

    }

    //Delete
    @DeleteMapping("/{id}")
    public void borrarReseñaPorId(@PathVariable int id) {
        reseñaService.borrarReseñaPorId(id);
    }

}
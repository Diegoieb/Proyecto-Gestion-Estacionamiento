package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioFlete;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioFleteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class ServicioFleteRestController {

    @Autowired
    IServicioFleteService servicioFlete;

    @GetMapping("/servicioFlete")
    public ResponseEntity<?> index(){
        Map<String,Object> response = new HashMap<>();
        List<ServicioFlete> listaServicio = null;
        try {
            listaServicio = servicioFlete.findAll();
            response.put("ok", true);
        } catch (DataAccessException e) {
            // TODO: handle exception
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            response.put("ok", false);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        response.put("servicioFlete", listaServicio);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

    }
    
    @DeleteMapping("/servicioFlete/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
        	servicioFlete.delete(id);
            response.put("Ok", "servicio flete eliminado");
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
    
}

package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class ServicioVulcanizacionRestController {

    @Autowired
    com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioVulcanizacionService servicioVulcanizacion;

    @GetMapping("/servioVulcanizacion")
    public ResponseEntity<?> index() {
        Map<String, Object> response = new HashMap<>();
        List<ServicioVulcanizacion> listaServicio;
        try {
            listaServicio = servicioVulcanizacion.findAll();
            response.put("ok", true);
        } catch (DataAccessException e) {
            // TODO: handle exception
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            response.put("ok", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("servicioVulcanizacion", listaServicio);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @PostMapping("/servioVulcanizacion")
    public ResponseEntity<?> guardarVulca(@RequestBody ServicioVulcanizacion servicioVulcanizacion2){
        Map<String, Object> response= new HashMap<>();
        ServicioVulcanizacion servicioVulcanizacion1= null;
        try{
            servicioVulcanizacion1= servicioVulcanizacion.save(servicioVulcanizacion2);
            response.put("trabajador", servicioVulcanizacion1);
        }catch(DataAccessException e){
            response.put("Mensaje", "Erro al realizar la consulta en la base de datos"+ e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
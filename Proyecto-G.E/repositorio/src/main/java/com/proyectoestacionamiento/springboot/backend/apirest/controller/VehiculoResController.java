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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IVehiculoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class VehiculoResController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/vehiculos")
    public ResponseEntity<?> index(){
        Map<String,Object> response = new HashMap<>();
        List<Vehiculo> vehiculos = null;
        try {
            vehiculos = vehiculoService.findAll();
            response.put("ok", true);
        } catch (DataAccessException e) {
            // TODO: handle exception
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            response.put("ok", false);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        response.put("vehiculos", vehiculos);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

    }
    
    @PostMapping("/vehiculos")
    public ResponseEntity<?> agregaVehiculo(@RequestBody Vehiculo vehiculo) {
        Map<String, Object> response = new HashMap<>();
        Vehiculo vehiculo2 = null;
        try {
            vehiculo2 = vehiculoService.save(vehiculo);
            response.put("vehiculo", vehiculo2);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos"+ e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}

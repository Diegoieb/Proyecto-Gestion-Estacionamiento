package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class VehiculoResController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/vehiculos")
    public ResponseEntity<?> index(){
        return vehiculoService.findAll();

    }
    
    @PostMapping("vehiculos")
    public ResponseEntity<?> agregaVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.save(vehiculo);
    }
}

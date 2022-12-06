package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioBanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class ServicioBanoRestController {


    @Autowired
    IServicioBanoService banoService;

    @GetMapping("/servicioBano")
    public ResponseEntity<?> index(){
        return banoService.findAll();
    }
}

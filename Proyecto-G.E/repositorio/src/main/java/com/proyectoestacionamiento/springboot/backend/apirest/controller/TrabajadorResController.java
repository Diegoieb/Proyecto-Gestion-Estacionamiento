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

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.service.ITrabajadorService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class TrabajadorResController {

    @Autowired
    ITrabajadorService trabajaroService;

    @GetMapping("/trabajadores")
    public ResponseEntity<?> index(){
        Map<String,Object> response = new HashMap<>();
        List<Trabajador> trabajador= null;
        try {
            trabajador = trabajaroService.findAll();
            response.put("ok", true);
        } catch (DataAccessException e) {
            // TODO: handle exception
            response.put("Mensaje","Error al realizar la consulta en la base de datos");
            response.put("ok", false);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        response.put("trabajadores", trabajador);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }


}

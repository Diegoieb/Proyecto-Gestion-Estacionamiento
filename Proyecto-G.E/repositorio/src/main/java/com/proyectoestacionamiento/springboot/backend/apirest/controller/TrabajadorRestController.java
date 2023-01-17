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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Trabajador;
import com.proyectoestacionamiento.springboot.backend.apirest.service.ITrabajadorService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class TrabajadorRestController {

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

    @PostMapping("/trabajadores")
    public ResponseEntity<?> guardarTrabajador(@RequestBody Trabajador trabajador){
        Map<String, Object> response= new HashMap<>();
        Trabajador trabajador1= null;
        try{
            trabajador1= trabajaroService.save(trabajador);
            response.put("trabajador", trabajador1);
        }catch(DataAccessException e){
            response.put("Mensaje", "Erro al realizar la consulta en la base de datos"+ e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/trabajadores/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            trabajaroService.delete(id);
            response.put("Ok", "trabajador eliminado");
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
 	
}

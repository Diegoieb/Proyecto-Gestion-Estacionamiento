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
    
     @PostMapping("/servioVulcanizacion/{id}")
    public ResponseEntity<?> actualizarVulcanizacion(@RequestBody ServicioVulcanizacion servV) {
        Map<String, Object> response = new HashMap<>();
        ServicioVulcanizacion servV2, servV3 = null;
        int id = Math.toIntExact(servV.getId());
        try {
            servV2 = servicioVulcanizacion.findById(id);
            servV2.setOcupado(servV.isOcupado());
            servV2.setPrecio(servV.getPrecio());
            servV2.setEstacionamiento(servV.getEstacionamiento());
            servV2.setTrabajador(servV.getTrabajador());
            servV3 = servicioVulcanizacion.save(servV2);
            response.put("Ok", servV3);// respuesta
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    @PostMapping("/servioVulcanizacion")
    public ResponseEntity<?> guardarVulca(@RequestBody ServicioVulcanizacion servicioVulcanizacion2){
        Map<String, Object> response= new HashMap<>();
        ServicioVulcanizacion servicioVulcanizacion1= null;
        try{
            servicioVulcanizacion1= servicioVulcanizacion.save(servicioVulcanizacion2);
            response.put("ServicioVulcanizacion", servicioVulcanizacion1);
        }catch(DataAccessException e){
            response.put("Mensaje", "Error al realizar la consulta en la base de datos"+ e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/servioVulcanizacion/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
        	servicioVulcanizacion.delete(id);
            response.put("Ok", "servicio eliminado");
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}
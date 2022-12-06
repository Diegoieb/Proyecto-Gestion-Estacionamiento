package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class ClienteResController {

    @Autowired
    IClienteService clienteService;

    //url de la consulta
    @GetMapping("/clientes")
    public ResponseEntity<?> index() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable int id) {
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes")
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente) {
        return clienteService.updateCliente(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable int id) {
        return clienteService.delete(id);
    }

}

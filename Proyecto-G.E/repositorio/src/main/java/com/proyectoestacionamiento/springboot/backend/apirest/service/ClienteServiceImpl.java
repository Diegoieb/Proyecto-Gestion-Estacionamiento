package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        List<Cliente> clientes;
        try {
            clientes = clienteRepository.findAll();
            response.put("ok", true);
        } catch (Exception e) {
            // TODO: handle exception
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            response.put("ok", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("clientes", clientes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(Cliente cliente) {
        Map<String, Object> response = new HashMap<>();
        try {
            clienteRepository.save(cliente);
            response.put("Ok", cliente);
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteRepository.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateCliente(Cliente cliente) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente2, cliente3;
        int id = Math.toIntExact(cliente.getId());
        try {
            cliente2 = clienteRepository.findById(id).get();
            cliente2.setDireccion(cliente.getDireccion());
            cliente2.setNombre(cliente.getNombre());
            cliente2.setNumero(cliente.getNumero());
            cliente2.setRut(cliente.getRut());
            cliente2.setVehiculos(cliente.getVehiculos());
            cliente3 = clienteRepository.save(cliente2);
            response.put("Ok", cliente3);// respuesta
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            clienteRepository.deleteById(id);
            response.put("Ok", null);
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

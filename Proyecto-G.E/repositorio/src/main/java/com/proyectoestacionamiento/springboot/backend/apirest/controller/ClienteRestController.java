package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Cliente;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IClienteService;
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
public class ClienteRestController {

    @Autowired
    IClienteService clienteService;

    //url de la consulta
    @GetMapping("/clientes")
    public ResponseEntity<?> index(){
        Map<String,Object> response = new HashMap<>();
        List<Cliente> clientes= null;
        try {
            clientes = clienteService.findAll();
            response.put("ok", true);
            
        } catch (DataAccessException e) {
            // TODO: handle exception
            response.put("Mensaje","Error al realizar la consulta en la base de datos");
            response.put("ok", false);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        response.put("clientes", clientes);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    
    
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable int id) {
		Cliente clientes = null;
		
		Map<String, Object>  response = new HashMap<>();
		try {
			clientes = clienteService.findById(id);
			
		}catch(RuntimeException e) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("ok", false);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		
		if(clientes == null) {
			response.put("ok", false);
			response.put("mensaje", "El cliente no se encuentra");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		response.put("cliente", clientes);
		response.put("ok", true);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
    
    
    @PostMapping("/clientes")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente){
        Map<String, Object> response= new HashMap<>();
        Cliente cliente1= null;
        try{
        	cliente1= clienteService.save(cliente);
            response.put("Cliente", cliente1);
        }catch(DataAccessException e){
            response.put("Mensaje", "Error al realizar la consulta en la base de datos"+ e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
	
	/*
    @PostMapping("/clientes")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente1 = null;
        try {
            cliente1 = clienteService.save(cliente);
            response.put("Ok", cliente);
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
	 */
    @PutMapping("/clientes")
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente2, cliente3 = null;
        int id = Math.toIntExact(cliente.getId());
        try {
            cliente2 = clienteService.findById(id);
            cliente2.setDireccion(cliente.getDireccion());
            cliente2.setNombre(cliente.getNombre());
            cliente2.setNumero(cliente.getNumero());
            cliente2.setRut(cliente.getRut());
            cliente2.setVehiculos(cliente.getVehiculos());
            cliente3 = clienteService.save(cliente2);
            response.put("Ok", cliente3);// respuesta
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            clienteService.delete(id);
            response.put("Ok", null);
        } catch (Exception e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

/*
    @DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable int id) {
		Map<String, Object>  response = new HashMap<>();
		
		try {
			
			clienteService.delete(id);
			response.put("Ok", null);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("Mensaje", "error al eliminar el autor de la base de datos"+e.getMessage());;
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND); 
		}
		response.put("Mensaje", "Cliente eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
 	*/
}

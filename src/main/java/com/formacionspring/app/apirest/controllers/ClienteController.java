package com.formacionspring.app.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.formacionspring.app.apirest.entity.Cliente;
import com.formacionspring.app.apirest.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping("/clientes")
	public List<Cliente> cliente(){
		return servicio.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente clienteShow(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping("/clientes")//Esto es para usar el metodo POST, es para crear un nuevo cliente.
	@ResponseStatus(HttpStatus.CREATED) //Esto nos trae una respuesta de codigo cuando realizamos una consulta de tipo HTTP
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return servicio.save(cliente);
	}
	
	//Lo siguiente lo creamos para actualizar los clientes
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		
		Cliente clienteUpdate = servicio.findById(id);
		
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefono(cliente.getTelefono());
		clienteUpdate.setCreatedAt(cliente.getCreatedAt());
		
		return servicio.save(clienteUpdate);
	}
	
	//Con esto eliminamos el cliente que elijamos y nos devuelve el cliente que hemos eliminado:
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente deleteCliente(@PathVariable Long id) {
		Cliente clienteBorrado=servicio.findById(id);
		servicio.delete(id);
		return clienteBorrado;
	}
	
	
}

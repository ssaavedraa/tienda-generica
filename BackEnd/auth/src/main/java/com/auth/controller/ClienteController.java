package com.auth.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entities.Cliente;
import com.auth.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController
{
	@Autowired
	private ClienteService clienteService;
	
	//CRUD
	
	//Crear Usuario
	@PostMapping
	public ResponseEntity<?> crear (@RequestBody Cliente cliente)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}
	
	//Buscar Usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long cedula_cliente)
	{
		Optional<Cliente> oCliente = clienteService.findById(cedula_cliente);
		
		if (!oCliente.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCliente);
		
	}
	
	//Actualizar Usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente clienteDetalles, @PathVariable(value="id") Long cedula_cliente)
	{
		Optional<Cliente> cliente = clienteService.findById(cedula_cliente);
		
		if (!cliente.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		cliente.get().setNombre_cliente(clienteDetalles.getNombre_cliente());
		cliente.get().setDireccion_cliente(clienteDetalles.getDireccion_cliente());
		cliente.get().setTelefono_cliente(clienteDetalles.getTelefono_cliente());
		cliente.get().setEmail_cliente(clienteDetalles.getEmail_cliente());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));
		
	}
	
	//Eliminar usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete( @PathVariable(value="id") Long cedula_cliente)
	{
		if(!clienteService.findById(cedula_cliente).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		clienteService.deleteById(cedula_cliente);
		return ResponseEntity.ok().build();
		
	}
	
	//Mostrar lista de  Proveedores
	@GetMapping
	public List<Cliente> mostrarTodos()
	{
		List<Cliente> clientes = StreamSupport
				.stream(clienteService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return clientes;
	}
	
	
}

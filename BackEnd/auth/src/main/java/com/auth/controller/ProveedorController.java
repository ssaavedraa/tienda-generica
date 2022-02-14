package com.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.auth.entities.Proveedor;
import com.auth.services.ProveedorService;

@RestController
@RequestMapping("proveedores/")
public class ProveedorController
{
	@Autowired
	private ProveedorService proveedorService;
	
	//CRUD
	
	//Crear Usuario
	@PostMapping("add")
	public ResponseEntity<?> crear (@RequestBody Proveedor proveedor)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor));
	}
	
	//Buscar Usuario
	@GetMapping("read/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long nit_proveedor)
	{
		Optional<Proveedor> oProveedor = proveedorService.findById(nit_proveedor);
		
		if (!oProveedor.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProveedor);
		
	}
	
	//Actualizar Usuario
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedorDetalles, @PathVariable(value="id") Long nit_proveedor)
	{
		Optional<Proveedor> proveedor = proveedorService.findById(nit_proveedor);
		
		if (!proveedor.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		proveedor.get().setNombre_proveedor(proveedorDetalles.getNombre_proveedor());
		proveedor.get().setDireccion_proveedor(proveedorDetalles.getDireccion_proveedor());
		proveedor.get().setTelefono_proveedor(proveedorDetalles.getTelefono_proveedor());
		proveedor.get().setCiudad_proveedor(proveedorDetalles.getCiudad_proveedor());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor.get()));
		
	}
	
	//Eliminar usuario
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete( @PathVariable(value="id") Long nit_proveedor)
	{
		Map<String, String> map = new HashMap<String, String>();
		if(!proveedorService.findById(nit_proveedor).isPresent())
		{
			map.put("status", "ERROR");
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		
		proveedorService.deleteById(nit_proveedor);
		map.put("status", "OK");
		return ResponseEntity.status(HttpStatus.OK).body(map);
		
	}
	
	//Mostrar lista de  Proveedores
	@GetMapping("read")
	public List<Proveedor> mostrarTodos(){
		List<Proveedor> proveedores = StreamSupport
				.stream(proveedorService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return proveedores;
	}
	
	
}

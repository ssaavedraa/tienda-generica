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

import com.auth.entities.Usuario;
import com.auth.services.UserService;

@RestController
@RequestMapping("users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Create (POST)
	@PostMapping("add")
	public ResponseEntity<?> create(@RequestBody Usuario user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	//Read (GET)
	@GetMapping("read/{cedula_usuario}")
	public ResponseEntity<?> read(@PathVariable Long cedula_usuario){
		Optional<Usuario> oUser =userService.findById(cedula_usuario);
		
		if (!oUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		
		return ResponseEntity.ok(oUser);
	}
	
	//Update (PUT)
	@PutMapping("{cedula_usuario}")
	public ResponseEntity<?> read(@RequestBody Usuario userDetails, @PathVariable Long cedula_usuario){
		Optional<Usuario> user = userService.findById(cedula_usuario);
		
		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		user.get().setNombre_usuario(userDetails.getNombre_usuario());
		user.get().setEmail_usuario(userDetails.getEmail_usuario());
		user.get().setUsuario(userDetails.getUsuario());
		user.get().setPassword(userDetails.getPassword());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	//Delete (DELETE)
	@DeleteMapping("{cedula_usuario}")
	public ResponseEntity<?> delete(@PathVariable Long cedula_usuario){
		Map<String, String> map = new HashMap<String, String>();
		if (!userService.findById(cedula_usuario).isPresent()) {
			map.put("status", "ERROR");
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		
		userService.deleteById(cedula_usuario);
		map.put("status", "OK");
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	
	//Read all (GET)
	@GetMapping("read")
	public List<Usuario> readAll(){
		
		List<Usuario> users = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return users;
	}
	
	@PostMapping("auth")
	public ResponseEntity<?> findByUsuarioAndPassword(@RequestBody Usuario user){
		Map<String, String> map = new HashMap<String, String>();
		Optional<Usuario> authUser = userService.findByUsuarioAndPassword(user.getUsuario(), user.getPassword());
		if (!authUser.isPresent()) {
			map.put("status", "ERROR");
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		map.put("status", "OK");
		map.put("usuario", authUser.get().getNombre_usuario());
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	
		
}

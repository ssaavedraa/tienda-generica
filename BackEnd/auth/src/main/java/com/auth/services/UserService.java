package com.auth.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auth.entities.Usuario;

public interface UserService {
	
	public Iterable<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Optional<Usuario> findById(Long cedula_usuario);
	
	public Usuario save(Usuario user);
	
	public void deleteById(Long cedula_usuario);
	
	public Optional<Usuario> findByUsuarioAndPassword(String usuario, String password);
	
}

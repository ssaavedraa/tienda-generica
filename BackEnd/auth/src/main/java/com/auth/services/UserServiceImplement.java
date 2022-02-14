package com.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entities.Usuario;
import com.auth.repositories.UserRepository;

@Service
public class UserServiceImplement implements UserService{

	@Autowired
	private UserRepository userRepository;
		
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long cedula_usuario) {
		return userRepository.findById(cedula_usuario);
	}

	@Override
	public Usuario save(Usuario user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Long cedula_usuario) {		
		userRepository.deleteById(cedula_usuario);
	}
	
	@Override
	public Optional<Usuario> findByUsuarioAndPassword(String usuario, String password) {
		Optional<Usuario> user = userRepository.findByUsuarioAndPassword(usuario, password);
		return user;
	}
	
}

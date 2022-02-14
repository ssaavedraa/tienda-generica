package com.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByUsuarioAndPassword(String usuario, String password);
	
}
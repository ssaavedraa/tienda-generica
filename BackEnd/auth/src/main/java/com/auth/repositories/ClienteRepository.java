package com.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Long>
{
	

}

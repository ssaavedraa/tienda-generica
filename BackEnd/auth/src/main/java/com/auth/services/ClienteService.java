package com.auth.services;

import java.util.Optional;

import com.auth.entities.Cliente;

public interface ClienteService
{
	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(Long cedula_cliente);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Long cedula_cliente);	
	
}
package com.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.auth.repositories.ClienteRepository;
import com.auth.entities.Cliente;

@Service
public class ClienteServiceImplement implements ClienteService
{
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findAll()
	{
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Long cedula_cliente)
	{
		return clienteRepository.findById(cedula_cliente);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long cedula_cliente)
	{
		clienteRepository.deleteById(cedula_cliente);
	}

}
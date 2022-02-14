package com.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.auth.repositories.ProveedorRepository;
import com.auth.entities.Proveedor;

@Service
public class ProveedorServiceImplement implements ProveedorService
{
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Proveedor> findAll()
	{
		return proveedorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedor> findById(Long nit_proveedor)
	{
		return proveedorRepository.findById(nit_proveedor);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	@Transactional
	public void deleteById(Long nit_proveedor)
	{
			proveedorRepository.deleteById(nit_proveedor);
	}

}

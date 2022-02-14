package com.auth.services;

import java.util.Optional;

import com.auth.entities.Proveedor;

public interface ProveedorService
{
	public Iterable<Proveedor> findAll();
	
	public Optional<Proveedor> findById(Long nit_proveedor);
	
	public Proveedor save(Proveedor proveedor);
	
	public void deleteById(Long nit_proveedor);	
	
}

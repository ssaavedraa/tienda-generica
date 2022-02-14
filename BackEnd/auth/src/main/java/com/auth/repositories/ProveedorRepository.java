package com.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entities.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository <Proveedor,Long>
{
	

}

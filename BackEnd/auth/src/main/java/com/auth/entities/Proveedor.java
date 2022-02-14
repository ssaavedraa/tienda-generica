package com.auth.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")

public class Proveedor
{

	@Id
	@Column(nullable = false, unique = true)
	private Long nit_proveedor;
	
	@Column(nullable = false)
	private String nombre_proveedor;
	
	@Column(nullable = false)
	private String direccion_proveedor;
	
	@Column(nullable = false)
	private String telefono_proveedor;
	
	@Column(nullable = false)
	private String ciudad_proveedor;
	
	public Long getnit_proveedor() {
		return nit_proveedor;
	}

	public void setnit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}
	

	
	
}
package com.auth.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente
{
	@Id
	@Column(nullable = false, unique = true)
	private Long cedula_cliente;
	
	@Column(nullable = false)
	private String nombre_cliente;
	
	@Column(nullable = false)
	private String direccion_cliente;
	
	@Column(nullable = false)
	private String telefono_cliente;
	
	@Column(nullable = false)
	private String email_cliente;
	
		
	public Cliente(Long cedula_cliente, String nombre_cliente, String direccion_cliente, String telefono_cliente,
			String email_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.direccion_cliente = direccion_cliente;
		this.telefono_cliente = telefono_cliente;
		this.email_cliente = email_cliente;
	}

	//Getters and Setters
	public Long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	
	

	
	
}
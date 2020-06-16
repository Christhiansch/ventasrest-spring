package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "personas")
public class Persona
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Column(name = "nombres", length=50, nullable = true)
	private String nombres;
	
	@Column(name = "apellidos", length=50, nullable = true)
	private String apellidos;

	public Integer getIdPersona()
	{
		return idPersona;
	}

	public void setIdPersona(Integer idPersona)
	{
		this.idPersona = idPersona;
	}

	public String getNombres()
	{
		return nombres;
	}

	public void setNombres(String nombres)
	{
		this.nombres = nombres;
	}

	public String getApellidos()
	{
		return apellidos;
	}

	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}
}

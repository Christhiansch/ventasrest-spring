package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos" )
public class Producto
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@Column(name = "nombre", length=50, nullable = false)
	private String nombre;
	
	@Column(name = "marca", length=50, nullable = false)
	private String marca;

	public Integer getIdProducto()
	{
		return idProducto;
	}

	public void setIdProducto(Integer idProducto)
	{
		this.idProducto = idProducto;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}
}

package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventas" )
public class Venta
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@Column(name = "id_persona", nullable = false)
	private Persona idPersona;
	
	@Column(name = "importe", nullable = false)
	private Double importe;
	
	@OneToMany(mappedBy = "idVenta", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetalleVenta> detalleVenta;

	public Integer getIdVenta()
	{
		return idVenta;
	}

	public void setIdVenta(Integer idVenta)
	{
		this.idVenta = idVenta;
	}

	public LocalDateTime getFecha()
	{
		return fecha;
	}

	public void setFecha(LocalDateTime fecha)
	{
		this.fecha = fecha;
	}

	public Persona getIdPersona()
	{
		return idPersona;
	}

	public void setIdPersona(Persona idPersona)
	{
		this.idPersona = idPersona;
	}

	public Double getImporte()
	{
		return importe;
	}

	public void setImporte(Double importe)
	{
		this.importe = importe;
	}

	public List<DetalleVenta> getDetalleVenta()
	{
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVenta> detalleVenta)
	{
		this.detalleVenta = detalleVenta;
	}
		
}

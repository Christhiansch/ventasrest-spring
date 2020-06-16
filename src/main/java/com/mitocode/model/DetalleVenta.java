package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_ventas" )
public class DetalleVenta
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleVenta;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_VENTA_DETALLE"))
	private Venta idVenta;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCTO_VENTA"))
	private Producto idProducto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	public Integer getIdDetalleVenta()
	{
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta)
	{
		this.idDetalleVenta = idDetalleVenta;
	}

	public Venta getIdVenta()
	{
		return idVenta;
	}

	public void setIdVenta(Venta idVenta)
	{
		this.idVenta = idVenta;
	}

	public Producto getIdProducto()
	{
		return idProducto;
	}

	public void setIdProducto(Producto idProducto)
	{
		this.idProducto = idProducto;
	}

	public Integer getCantidad()
	{
		return cantidad;
	}

	public void setCantidad(Integer cantidad)
	{
		this.cantidad = cantidad;
	}

}

package com.mitocode.dto;

import java.util.List;

import com.mitocode.model.DetalleVenta;
import com.mitocode.model.Venta;

public class DetalleVentaDTO
{

	private Venta venta;
	private List<DetalleVenta> detalleVenta;

	public Venta getVenta()
	{
		return venta;
	}

	public void setVenta(Venta venta)
	{
		this.venta = venta;
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

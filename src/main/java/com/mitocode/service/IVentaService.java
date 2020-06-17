package com.mitocode.service;

import com.mitocode.dto.DetalleVentaDTO;
import com.mitocode.model.Venta;

public interface IVentaService extends ICRUD<Venta, Integer>
{
	Venta registrarTransaccional(DetalleVentaDTO ventaDTO) throws Exception;
}

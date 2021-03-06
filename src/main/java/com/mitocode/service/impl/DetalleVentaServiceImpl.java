package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.DetalleVenta;
import com.mitocode.repo.IDetalleVentaRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IDetalleVentaService;

@Service
public class DetalleVentaServiceImpl extends CRUDImpl<DetalleVenta, Integer> implements IDetalleVentaService
{

	@Autowired
	private IDetalleVentaRepo dtlleVentaRepo;
	
	@Override
	protected IGenericRepo<DetalleVenta, Integer> genericRepo()
	{
		return dtlleVentaRepo;
	}

}

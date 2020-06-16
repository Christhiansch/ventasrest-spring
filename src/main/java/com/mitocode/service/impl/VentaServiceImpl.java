package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVenta;
import com.mitocode.service.IVentaService;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService
{
	
	@Autowired
	private IVenta ventaRepo;
	
	@Override
	protected IGenericRepo<Venta, Integer> genericRepo()
	{
		return ventaRepo;
	}

}

package com.mitocode.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dto.DetalleVentaDTO;
import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService
{
	
	@Autowired
	private IVentaRepo ventaRepo;
	
	@Override
	protected IGenericRepo<Venta, Integer> genericRepo()
	{
		return ventaRepo;
	}

	@Override
	@Transactional
	public Venta registrarTransaccional(Venta venta) throws Exception
	{
		
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));			
		return ventaRepo.save(venta);
	}
	

}

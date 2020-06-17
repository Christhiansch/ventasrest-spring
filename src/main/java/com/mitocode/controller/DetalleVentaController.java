package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.DetalleVenta;
import com.mitocode.service.IDetalleVentaService;

@RestController
@RequestMapping("/detalleVentas")
public class DetalleVentaController
{

	@Autowired
	private IDetalleVentaService dtVentaService;

	public ResponseEntity<List<DetalleVenta>> listar() throws Exception
	{
		List<DetalleVenta> lista = dtVentaService.listar();
		return new ResponseEntity<List<DetalleVenta>>(lista, HttpStatus.OK);
	}

	public ResponseEntity<DetalleVenta> registrar(DetalleVenta obj) throws Exception
	{
		return null;
	}

	public ResponseEntity<DetalleVenta> listarPorId(Integer id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<DetalleVenta> modificar(DetalleVenta obj, @PathVariable("id") Integer id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<Void> eliminar(Integer id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}

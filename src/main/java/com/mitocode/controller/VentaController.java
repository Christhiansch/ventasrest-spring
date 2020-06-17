package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.dto.DetalleVentaDTO;
import com.mitocode.model.Venta;
import com.mitocode.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController
{

	@Autowired
	private IVentaService ventaService;

	public ResponseEntity<List<Venta>> listar() throws Exception
	{
		List<Venta> lista = ventaService.listar();
		return new ResponseEntity<List<Venta>>(lista, HttpStatus.OK);
	}

	public ResponseEntity<Venta> registrar(@RequestBody DetalleVentaDTO dto) throws Exception
	{
		Venta venta = ventaService.registrarTransaccional(dto);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	public ResponseEntity<Venta> listarPorId(Integer id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<Venta> modificar(Venta obj, @PathVariable("id") Integer id) throws Exception
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

package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Producto;
import com.mitocode.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController
{

	@Autowired
	private IProductoService productoService;

	@GetMapping
	public ResponseEntity<List<Producto>> listar() throws Exception
	{
		List<Producto> lista = productoService.listar();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Producto> registrar(@RequestBody Producto obj) throws Exception
	{
		Producto prod = productoService.registrar(obj);
		return new ResponseEntity<Producto>(prod, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) throws Exception
	{
		Producto prod = productoService.listarPorId(id);
		if (prod == null)
		{
			throw new ModelNotFoundException("ID no encontrado: " + id);
		}
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Producto> modificar(@RequestBody Producto obj, @PathVariable("id") Integer id) throws Exception
	{
		Producto prod = productoService.modificar(obj);
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception
	{
		Producto prod = productoService.listarPorId(id);
		if (prod == null)
		{
			throw new ModelNotFoundException("ID no encontrado: " + id);
		}
		productoService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}

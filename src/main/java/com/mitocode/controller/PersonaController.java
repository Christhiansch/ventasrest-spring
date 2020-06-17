package com.mitocode.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController
{
	@Autowired
	private IPersonaService personaService;

	@GetMapping
	public ResponseEntity<List<Persona>> listar() throws Exception
	{
		List<Persona> lista = personaService.listar();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception
	{
		Persona persona = personaService.listarPorId(id);
		if(persona == null)
		{
			throw new ModelNotFoundException("Id No encontrado: " + id);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.CREATED);
	}
	
	//Nivel 3 de Madurez de Richardson
	@GetMapping("/hateoas/{id}")
	public EntityModel<Persona> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception
	{
		Persona p = personaService.listarPorId(id);
		if(p == null)
		{
			throw new ModelNotFoundException("Id no encontrado: " + id);
		}
		
		EntityModel<Persona> recurso = EntityModel.of(p);
		WebMvcLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).listarPorId(id));
		
		recurso.add(linkTo.withRel("persona-recurso"));
		
		return recurso;
	}
	
	@PostMapping
	public ResponseEntity<Persona> registrar(@RequestBody Persona persona) throws Exception
	{
		Persona obj = personaService.registrar(persona);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Persona> modificar(@RequestBody Persona persona) throws Exception
	{
		Persona obj = personaService.modificar(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception
	{
		Persona p = personaService.listarPorId(id);
		if(p == null)
		{
			throw new ModelNotFoundException("Id no Encontrado: " + id);
		}
		personaService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

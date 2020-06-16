package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Persona;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPersona;
import com.mitocode.service.IPersonaService;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService
{
	
	@Autowired
	private IPersona personaRepo;

	@Override
	protected IGenericRepo<Persona, Integer> genericRepo()
	{
		// TODO Auto-generated method stub
		return personaRepo;
	}

}

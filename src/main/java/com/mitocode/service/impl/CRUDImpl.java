package com.mitocode.service.impl;

import java.util.List;

import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICRUD;

public abstract class CRUDImpl<T, V> implements ICRUD<T, V>
{

	protected abstract IGenericRepo<T, V> genericRepo();

	@Override
	public T registrar(T obj) throws Exception
	{
		return genericRepo().save(obj);
	}

	@Override
	public T modificar(T obj) throws Exception
	{
		return genericRepo().save(obj);
	}

	@Override
	public List<T> listar() throws Exception
	{
		return genericRepo().findAll();
	}

	@Override
	public T listarPorId(V id) throws Exception
	{
		return genericRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(V id) throws Exception
	{
		genericRepo().deleteById(id);
	}

}

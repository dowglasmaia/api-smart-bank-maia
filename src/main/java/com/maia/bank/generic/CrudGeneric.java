package com.maia.bank.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maia.bank.services.exceptions.ObjectNotFoundExecption;

public abstract class CrudGeneric<T, PK extends Serializable> implements CrudServices<T, PK> {
	private static final long serialVersionUID = 1L;
	
	private JpaRepository<T, PK> repository;	
	
	public CrudGeneric(JpaRepository<T, PK> repo ) {
		this.repository = repo;
		
	}
	
	@Override
	public T save(T entity) {
		return repository.save(entity);
	}


	@Override
	public T findById(PK id) {
		return repository.findById(id).orElseThrow(
			()-> new ObjectNotFoundExecption( "Nenhum resulatdoo encontrado para o ID" + id)	);
	}

	@Override
	public T findByParamName(String paramName) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}
	
	

}

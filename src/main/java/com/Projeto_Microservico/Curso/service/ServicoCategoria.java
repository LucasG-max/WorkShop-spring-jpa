package com.Projeto_Microservico.Curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto_Microservico.Curso.entities.Categoria;
import com.Projeto_Microservico.Curso.repositories.RepositorioCategoria;

@Service
public class ServicoCategoria {

	@Autowired
	private RepositorioCategoria repositorio;
	
	public List <Categoria> findAll(){
		return repositorio.findAll();
	}
	
	public Categoria encontrarId(long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	
	}
	
}

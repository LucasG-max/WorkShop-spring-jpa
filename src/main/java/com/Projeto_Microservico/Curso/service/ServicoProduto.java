package com.Projeto_Microservico.Curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto_Microservico.Curso.entities.Produto;
import com.Projeto_Microservico.Curso.repositories.RepositorioProduto;


@Service
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repositorio;
	
	public List <Produto> findAll(){
		return repositorio.findAll();
	}
	
	public Produto encontrarId(long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
	
}
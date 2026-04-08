package com.Projeto_Microservico.Curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto_Microservico.Curso.entities.Pedidos;
import com.Projeto_Microservico.Curso.repositories.RepositorioPedidos;

@Service
public class ServicoPedidos {

	@Autowired
	private RepositorioPedidos repositorioP;
	
	public List <Pedidos> findAll(){
		return repositorioP.findAll();
	}
	
	public Pedidos encontrarId(long id) {
		Optional<Pedidos> obj = repositorioP.findById(id);
		return obj.get();
	}
	
}

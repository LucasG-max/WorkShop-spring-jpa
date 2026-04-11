package com.Projeto_Microservico.Curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.repositories.RepositorioUsuarios;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuarios repositorio;
	
	public List <Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario encontrarId(long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	@PostMapping
	public Usuario inserir(Usuario obj){
		return repositorio.save(obj);
	}
}

package com.Projeto_Microservico.Curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.repositories.RepositorioUsuarios;
import com.Projeto_Microservico.Curso.service.exceptions.ResourceNotFoundException;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuarios repositorio;
	
	public List <Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario encontrarId(long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	
	public Usuario inserir(Usuario obj){
		return repositorio.save(obj);
	}
	
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario updateUSuario(Long id, Usuario obj) {
		Usuario entity = repositorio.getReferenceById(id);
		updateUsuario(entity, obj);
		return repositorio.save(entity);
	}

	private void updateUsuario(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		
	}
}

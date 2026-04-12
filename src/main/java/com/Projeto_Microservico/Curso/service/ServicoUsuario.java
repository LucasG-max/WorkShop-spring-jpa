package com.Projeto_Microservico.Curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.repositories.RepositorioUsuarios;
import com.Projeto_Microservico.Curso.service.exceptions.DatabaseException;
import com.Projeto_Microservico.Curso.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuarios repositorio;

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario encontrarId(long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}

	public void deletar(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public Usuario updateUSuario(Long id, Usuario obj) {
		try {
			Usuario entity = repositorio.getReferenceById(id);
			updateUsuario(entity, obj);
			return repositorio.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateUsuario(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());

	}
}

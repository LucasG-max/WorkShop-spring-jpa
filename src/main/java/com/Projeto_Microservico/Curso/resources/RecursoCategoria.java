package com.Projeto_Microservico.Curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto_Microservico.Curso.entities.Categoria;
import com.Projeto_Microservico.Curso.service.ServicoCategoria;

@RestController
@RequestMapping(value = "/Categoria")
public class RecursoCategoria {

	@Autowired
	private ServicoCategoria servicoCategoria;

	@GetMapping
	public ResponseEntity<List<Categoria>> EncontrarUsuario() {
		List<Categoria> lista = servicoCategoria.findAll();
		return ResponseEntity.ok().body(lista);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> EncontrarID(@PathVariable long id) {
		Categoria obj = servicoCategoria.encontrarId(id);
		return ResponseEntity.ok().body(obj);
	}

}

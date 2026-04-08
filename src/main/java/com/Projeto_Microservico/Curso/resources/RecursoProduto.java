package com.Projeto_Microservico.Curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto_Microservico.Curso.entities.Produto;
import com.Projeto_Microservico.Curso.service.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {

	@Autowired
	private ServicoProduto servicoProduto;

	@GetMapping
	public ResponseEntity<List<Produto>> EncontrarUsuario() {
		List<Produto> lista = servicoProduto.findAll();
		return ResponseEntity.ok().body(lista);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> EncontrarID(@PathVariable long id) {
		Produto obj = servicoProduto.encontrarId(id);
		return ResponseEntity.ok().body(obj);
	}

}

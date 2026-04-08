package com.Projeto_Microservico.Curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto_Microservico.Curso.entities.Pedidos;
import com.Projeto_Microservico.Curso.service.ServicoPedidos;

@RestController
@RequestMapping(value = "/Pedidoss")
public class RecursoPedido {

	@Autowired
	private ServicoPedidos servicoPedidos;

	@GetMapping
	public ResponseEntity<List<Pedidos>> EncontrarUsuario() {
		List<Pedidos> lista = servicoPedidos.findAll();
		return ResponseEntity.ok().body(lista);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedidos> EncontrarID(@PathVariable long id) {
		Pedidos obj = servicoPedidos.encontrarId(id);
		return ResponseEntity.ok().body(obj);
	}

}

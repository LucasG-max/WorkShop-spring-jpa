package com.Projeto_Microservico.Curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto_Microservico.Curso.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

	@GetMapping
	public ResponseEntity<Usuario> Returno_Usuario(){
		Usuario user = new Usuario(1L,"Lucas","Lucas@gmail.com","1111-1111","admin");
		return ResponseEntity.ok().body(user);
	}
}

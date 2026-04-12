package com.Projeto_Microservico.Curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.service.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

	@Autowired
	private ServicoUsuario servico;

	@GetMapping
	public ResponseEntity<List<Usuario>> EncontrarUsuario() {
		List<Usuario> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> EncontrarID(@PathVariable long id) {
		Usuario obj = servico.encontrarId(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj) {
		obj = servico.inserir(obj);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id ){
		servico.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		obj = servico.updateUSuario(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}

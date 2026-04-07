package com.Projeto_Microservico.Curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Projeto_Microservico.Curso.entities.Pedidos;
import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.repositories.RepositorioPedidos;
import com.Projeto_Microservico.Curso.repositories.RepositorioUsuarios;
@Configuration
@Profile("test")

public class TestConfigu implements CommandLineRunner {

	@Autowired
	private RepositorioUsuarios  repositorioUsuarios ;
	
	@Autowired
	private RepositorioPedidos repositorioPedidos;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario (null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario (null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Pedidos p1 = new Pedidos (null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Pedidos p2 = new Pedidos (null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Pedidos p3 = new Pedidos (null, Instant.parse("2019-07-22T15:21:22Z"), u1); 

		
		repositorioUsuarios.saveAll(Arrays.asList(u1,u2));
		repositorioPedidos.saveAll(Arrays.asList(p1,p2,p3));
	}
}

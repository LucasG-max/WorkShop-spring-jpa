package com.Projeto_Microservico.Curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.repositories.RepositorioUsuarios;
@Configuration
@Profile("test")

public class TestConfigu implements CommandLineRunner {

	@Autowired
	private RepositorioUsuarios  repositorioUsuarios ;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario (null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		repositorioUsuarios.saveAll(Arrays.asList(u1,u2));
	}

}

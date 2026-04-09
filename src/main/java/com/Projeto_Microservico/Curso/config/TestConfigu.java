package com.Projeto_Microservico.Curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Projeto_Microservico.Curso.entities.Categoria;
import com.Projeto_Microservico.Curso.entities.Pedidos;
import com.Projeto_Microservico.Curso.entities.Produto;
import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.repositories.RepositorioCategoria;
import com.Projeto_Microservico.Curso.repositories.RepositorioPedidos;
import com.Projeto_Microservico.Curso.repositories.RepositorioProduto;
import com.Projeto_Microservico.Curso.repositories.RepositorioUsuarios;

@Configuration
@Profile("test")

public class TestConfigu implements CommandLineRunner {
	
	@Autowired
	private RepositorioProduto repositorioProduto;

	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Autowired
	private RepositorioUsuarios repositorioUsuarios;

	@Autowired
	private RepositorioPedidos repositorioPedidos;

	@Override
	public void run(String... args) throws Exception {
		
		Produto pro1 = new Produto(null, "O Senhor dos Anéis", "Uma história épica de aventura em um mundo de fantasia.", 90.5, "");
		Produto pro2 = new Produto(null, "Smart TV", "Televisão inteligente com alta qualidade de imagem e acesso a aplicativos.", 2190.0, "");
		Produto pro3 = new Produto(null, "MacBook Pro", "Notebook de alto desempenho ideal para trabalho e estudos.", 1250.0, "");
		Produto pro4 = new Produto(null, "PC Gamer", "Computador potente para jogos com alto desempenho gráfico.", 1200.0, "");
		Produto pro5 = new Produto(null, "Rails para Iniciantes", "Guia prático para aprender Ruby on Rails do zero.", 100.99, "");
		repositorioProduto.saveAll(Arrays.asList(pro1,pro2,pro3,pro4,pro5));
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		pro1.getCategorias().add(cat2);
		pro2.getCategorias().add(cat1);
		pro2.getCategorias().add(cat3);
		pro3.getCategorias().add(cat3);
		pro4.getCategorias().add(cat3);
		pro5.getCategorias().add(cat2);
		
		repositorioProduto.saveAll(Arrays.asList(pro1,pro2,pro3,pro4,pro5));
		
	
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		repositorioUsuarios.saveAll(Arrays.asList(u1, u2));
		
		Pedidos p1 = new Pedidos(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Pedidos p2 = new Pedidos(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Pedidos p3 = new Pedidos(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		
		repositorioPedidos.saveAll(Arrays.asList(p1, p2, p3));
	}
}

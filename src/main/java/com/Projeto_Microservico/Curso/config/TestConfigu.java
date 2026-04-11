package com.Projeto_Microservico.Curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Projeto_Microservico.Curso.entities.Categoria;
import com.Projeto_Microservico.Curso.entities.ItemPedido;
import com.Projeto_Microservico.Curso.entities.Pagamento;
import com.Projeto_Microservico.Curso.entities.Pedidos;
import com.Projeto_Microservico.Curso.entities.Produto;
import com.Projeto_Microservico.Curso.entities.Usuario;
import com.Projeto_Microservico.Curso.entities.enums.StatusPedido;
import com.Projeto_Microservico.Curso.repositories.RepositorioCategoria;
import com.Projeto_Microservico.Curso.repositories.RepositorioItemPedido;
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
	
	@Autowired
	private RepositorioItemPedido repositorioItemPedido; 

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
		
	
		Usuario user1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario user2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		repositorioUsuarios.saveAll(Arrays.asList(user1, user2));
		
		Pedidos pedido1 = new Pedidos(null, Instant.parse("2019-06-20T19:53:07Z"),StatusPedido.PAGO ,user1);
		Pedidos pedido2 = new Pedidos(null, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.AGUARDANDO_PAGAMENTO ,user2);
		Pedidos pedido3 = new Pedidos(null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.AGUARDANDO_PAGAMENTO  ,user1);
		repositorioPedidos.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		ItemPedido ItemDePedido1 = new ItemPedido(pedido1, pro1, 2, pro1.getPreco());
		ItemPedido ItemDePedido2 = new ItemPedido(pedido1, pro3, 1, pro3.getPreco());
		ItemPedido ItemDePedido3 = new ItemPedido(pedido2, pro3, 2, pro3.getPreco());
		ItemPedido ItemDePedido4 = new ItemPedido(pedido3, pro5, 2, pro5.getPreco()); 
		repositorioItemPedido.saveAll(Arrays.asList(ItemDePedido1,ItemDePedido2,ItemDePedido3,ItemDePedido4));
		
		Pagamento pagamento1 = new Pagamento(null,Instant.parse("2019-06-20T20:15:07Z"),pedido1);
		pedido1.setPagamento(pagamento1);
	}
}

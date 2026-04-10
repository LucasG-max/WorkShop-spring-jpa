package com.Projeto_Microservico.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projeto_Microservico.Curso.entities.ItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido,Long>{

}

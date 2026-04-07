package com.Projeto_Microservico.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projeto_Microservico.Curso.entities.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria,Long>{

}

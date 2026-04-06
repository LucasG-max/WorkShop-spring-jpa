package com.Projeto_Microservico.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projeto_Microservico.Curso.entities.Usuario;

public interface RepositorioUsuarios extends JpaRepository<Usuario,Long>{

}

package com.ribeiro.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ribeiro.livraria.domain.Categoria;

@Repository /* agregacao aos objetos de negocio e dominio (Categoria) */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}

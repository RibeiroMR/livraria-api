package com.ribeiro.livraria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ribeiro.livraria.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	/*
	 * Implementando consulta formato JPQL. Passando o :id_cat como parametro
	 * conforme o argumento @Param("id_cat"), para retornar todos os Livro de acordo
	 * com o Id de uma Categoria
	 */
	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

}

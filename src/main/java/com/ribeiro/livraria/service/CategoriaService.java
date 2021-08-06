package com.ribeiro.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribeiro.livraria.domain.Categoria;
import com.ribeiro.livraria.repositories.CategoriaRepository;
import com.ribeiro.livraria.service.exceptions.ObjectNotFoundException;

/* Declara que a classe e um entidade de Servico, onde sao processado os dados
 * com base no negocio
 */
@Service
public class CategoriaService {

	@Autowired /* fazendo a Injeção (Instanciaçao) de CategoriaRepository */
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		/*
		 * metodo nativo JpaRepository do Spring Data Jpa, buscando automaticamente pelo
		 * ID da tabela Categoria
		 */
		Optional<Categoria> obj = categoriaRepository.findById(id);

		/*
		 * Arrow Function personalizada da classe ObjectNotFoundException do pacote
		 * service.exceptions, no caso de uma busca por ID retornar vazio
		 */
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		/* retorna uma lista de todas as Categorias no dominio */
		return categoriaRepository.findAll();
	}
}

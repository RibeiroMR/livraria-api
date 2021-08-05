package com.ribeiro.livraria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribeiro.livraria.domain.Categoria;
import com.ribeiro.livraria.repositories.CategoriaRepository;

@Service /* Declara que a classe e um entidade de Servico, onde sao processado os dados com base no negocio */
public class CategoriaService {

	@Autowired /* fazendo a Injeção (Instanciaçao) de CategoriaRepository */
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id); /* metodo nativo JpaRepository do Spring Data Jpa, buscando automaticamente pelo ID da tabela Categoria */
		return obj.orElse(null); /* Retorna o obj caso instanciado, senao retorna null */
	}
}

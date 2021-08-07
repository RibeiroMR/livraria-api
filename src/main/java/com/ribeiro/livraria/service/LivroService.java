package com.ribeiro.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ribeiro.livraria.domain.Livro;
import com.ribeiro.livraria.dtos.LivroDTO;
import com.ribeiro.livraria.repositories.LivroRepository;
import com.ribeiro.livraria.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		/* validando se a categoria realmente existe */
		categoriaService.findById(id_cat);
		/*
		 * as classes Repository nao possuem metodos nativos para retornar buscas pelas
		 * classes associadas, nescessitando criar uma personalizada no Repository
		 */
		return livroRepository.findAllByCategoria(id_cat);
	}
}

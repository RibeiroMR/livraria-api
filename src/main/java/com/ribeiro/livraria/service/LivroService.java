package com.ribeiro.livraria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribeiro.livraria.domain.Livro;
import com.ribeiro.livraria.repositories.LivroRepository;
import com.ribeiro.livraria.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
}

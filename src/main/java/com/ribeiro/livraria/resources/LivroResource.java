package com.ribeiro.livraria.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.livraria.domain.Livro;
import com.ribeiro.livraria.dtos.LivroDTO;
import com.ribeiro.livraria.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro obj = livroService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * metodo para listar todos os livros de determinado Id de uma Categoria
	 * conforme @RequestParam, caso nao informado e passado o 0 para ativar excessao
	 */
	// localhost:8080/livros?categoria=1
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Livro> list = livroService.findAll(id_cat);
		List<LivroDTO> listDto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}

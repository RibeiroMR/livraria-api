package com.ribeiro.livraria.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.livraria.domain.Categoria;
import com.ribeiro.livraria.dtos.CategoriaDTO;
import com.ribeiro.livraria.service.CategoriaService;

@RestController /* Controlador REST retornando para HTTP um JSON (ou posivelmente XML) */
@RequestMapping(value = "/categorias") /* Define Endpoint da aplicacao para Categoria */
public class CategoriaResource {

	@Autowired /* fazendo a Injeção (Instanciação) de CategoriaService */
	private CategoriaService categoriaService;

	/*
	 * endpoint do tipo GET, recebendo o argumento Id retornando uma Categoria no
	 * corpo da aplicacao
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj); /* no corpo da resposta http retorna o obj */
	}

	/*
	 * quando ocorrer uma requisisao no endpoint /categoria sem argumento, sera
	 * retornado no corpo da requisisao do tipo lista de todas as categorias
	 */
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = categoriaService.findAll();
		/* transformando uma Lista de Categoria em uma Lista de CategoriaDTO */
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}

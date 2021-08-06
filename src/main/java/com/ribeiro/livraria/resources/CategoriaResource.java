package com.ribeiro.livraria.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 * quando ocorrer uma requisicao no endpoint /categoria sem argumento, sera
	 * retornado no corpo da requisicao do tipo lista de todas as categorias
	 */
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = categoriaService.findAll();
		/* transformando uma Lista de Categoria em uma Lista de CategoriaDTO */
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	/*
	 * Requisicao de endpoint POST, para criar um novo objeto na base de dados do
	 * tipo Categoria. No corpo da requisicao e carregado um objeto do tipo
	 * Categoria
	 */
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
		/*
		 * obj (Categoria) recebe ele mesmo apos inserir no banco, passando o proprio
		 * obj no parametro
		 */
		obj = categoriaService.create(obj);
		/*
		 * por questao de boas praticas,recomenda-se deve retorna para o usuario uma URI
		 * de acesso daquela novo objeto criado.
		 */
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		/*
		 * URI (Uniform Resource Identifier - cadeia de caracteres compacta usada para
		 * identificar ou denominar um recurso na Internet.)
		 */
		return ResponseEntity.created(uri).build();
	}

	/*
	 * Requisicao de endpoint PUT, para atualizar um objeto existente do tipo
	 * Categoria. Carregando um Id na path e um Dto de Categoria na requisicao
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto) {
		Categoria newObj = categoriaService.update(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}

	/*
	 * Requisicao de endpoint DELETE, para excluir um objeto existente do tipo
	 * Categoria. Carregando um Id na path da requisicao
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		categoriaService.delete(id);
		/* Retornando nenhum conteudo no corpo da requisicao */
		return ResponseEntity.noContent().build();
	}
}

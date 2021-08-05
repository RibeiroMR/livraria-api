package com.ribeiro.livraria.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribeiro.livraria.domain.Categoria;
import com.ribeiro.livraria.service.CategoriaService;

@RestController /* Controlador REST retornando para HTTP um JSON (ou posivelmente XML) */
@RequestMapping(value = "/categorias") /* Define Endpoint da aplicacao para Categoria */
public class CategoriaResource {

	@Autowired /* fazendo a Injeção (Instanciação) de CategoriaService */
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}") /* endpoint do tipo GET, recebendo recebendo ID retornando uma Categoria no corpo da aplicacao*/
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj); /* no corpo da resposta http retorna o obj */
	}
}

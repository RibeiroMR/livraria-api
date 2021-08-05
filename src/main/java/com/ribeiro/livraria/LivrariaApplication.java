package com.ribeiro.livraria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ribeiro.livraria.domain.Categoria;
import com.ribeiro.livraria.domain.Livro;
import com.ribeiro.livraria.repositories.CategoriaRepository;
import com.ribeiro.livraria.repositories.LivroRepository;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));

		categoriaRepository.saveAll(Arrays.asList(cat1));
		livroRepository.saveAll(Arrays.asList(l1));
	}

}

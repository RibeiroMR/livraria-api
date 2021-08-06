package com.ribeiro.livraria.dtos;

import java.io.Serializable;

import com.ribeiro.livraria.domain.Categoria;

/* DTO = data transder object
 * instancia objetos com mesmos atributos de Categoria mas sem a lista de Livros
 * consiste basicamente em agrupar um conjunto de atributos numa classe simples de forma a otimizar a comunicacao
 */
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;

	public CategoriaDTO() {
	}

	/* Construtor carregando um objeto do tipo Categoria */
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

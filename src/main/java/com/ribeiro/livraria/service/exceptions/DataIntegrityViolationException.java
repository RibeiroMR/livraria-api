package com.ribeiro.livraria.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/*
	 * Adiciona os construtores da superclasse RuntimeException(mensagem de erro,
	 * causa do erro), RuntimeException(mensagem de erro)
	 */
	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegrityViolationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}

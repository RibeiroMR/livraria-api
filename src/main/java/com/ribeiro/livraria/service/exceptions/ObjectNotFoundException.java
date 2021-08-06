package com.ribeiro.livraria.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	/*
	 * Tratando excecoes em tempo de execucao extendendo da classe RuntimeException
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjectNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

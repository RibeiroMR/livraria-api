package com.ribeiro.livraria.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/* Classe para tratar erros de validacao */
public class ValidationError extends StandardError {

	/* lista de FieldMessages */
	List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	/*
	 * invés de setErrors alterar para addErrors, de parametro receber error por
	 * error(campo e menssagem) e instancia em um novo objeto FieldMessage
	 */
	public void addErrors(String fieldName, String message) {
		/*
		 * metodo add(...) para adicionar o objeto em uma lista declarada para seu tipo
		 */
		this.errors.add(new FieldMessage(fieldName, message));
	}
}

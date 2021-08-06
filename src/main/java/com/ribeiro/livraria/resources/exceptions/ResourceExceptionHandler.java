package com.ribeiro.livraria.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ribeiro.livraria.service.exceptions.DataIntegrityViolationException;
import com.ribeiro.livraria.service.exceptions.ObjectNotFoundException;

/* classe que filtra a excecao dos recursos tratando de forma personalizada
 * @ControllerAdvice usado para manipulação global de erros no aplicativo Spring MVC. Ele também tem controle total sobre o corpo da resposta e o código de status.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	/* Manipulador de excecao da classe ObjectNotFoundException */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		/*
		 * instanciando uma objeto do tipo StandardError passando tempo, codigo da
		 * requisicao Http e mensagem de erro
		 */
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		/*
		 * retornando o status da requisicao Not Found (de que nao foi encontrado o
		 * objeto) e no corpo da resposposta o error carregado
		 */
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e,
			ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		/*
		 * retornando o status da requisicao Bad Request para previnir integridade de
		 * dados associados
		 */
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}

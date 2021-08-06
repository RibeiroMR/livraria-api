package com.ribeiro.livraria.resources.exceptions;

public class StandardError {

	private Long timestamp; /* momento que ocorreu a excecao */
	private Integer status; /* status do erro (ex.: 404, 401, ...)*/
	private String error; /* mensagem de erro */
	
	public StandardError() {
	}
	
	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}

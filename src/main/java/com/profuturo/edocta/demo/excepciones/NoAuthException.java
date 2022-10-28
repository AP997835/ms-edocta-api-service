package com.profuturo.edocta.demo.excepciones;

public class NoAuthException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String code = "401";

	public NoAuthException(String messageError) {
		super(messageError);

	}

	public String getCode() {
		return code;
	}
}

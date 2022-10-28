package com.profuturo.edocta.demo.excepciones;

public class NotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String messageError) {
		super(messageError);

	}

}

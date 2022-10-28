package com.profuturo.edocta.demo.excepciones;

import java.io.InputStream;

public class BadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream inputStreamResponse;

	public BadRequestException(String message) {
		super(message);

	}

	public BadRequestException(String message, InputStream inputStreamResponse) {
		super(message);
		this.inputStreamResponse = inputStreamResponse;
	}

	public InputStream getInputStreamResponse() {
		return inputStreamResponse;
	}

}

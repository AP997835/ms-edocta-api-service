package com.profuturo.edocta.demo.excepciones;

public class ServerUnavailableException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String code = "503";

	public ServerUnavailableException(String messageError) {
		super(messageError);
	}

	public String getCode() {
		return code;
	}
}

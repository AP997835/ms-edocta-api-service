package com.profuturo.edocta.demo.excepciones;

public class UnknownResourceServiceException extends RuntimeException {

    private static final long serialVersionUID = 8330860863595220574L;

    /**
     * @param msg
     */
    public UnknownResourceServiceException(String msg) {
        super(msg);
    }

    /**
     * @param mensaje
     * @param exception
     */
    public UnknownResourceServiceException(String mensaje, Throwable exception) {
        super(mensaje);
    }
}
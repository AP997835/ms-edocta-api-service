package com.profuturo.edocta.demo.excepciones;

public class CuatroCeroTresRequestException extends RuntimeException {

    private static final long serialVersionUID = 8330860863595220574L;

    /**
     * @param msg
     */
    public CuatroCeroTresRequestException(String msg) {
        super(msg);
    }

    /**
     * @param mensaje
     * @param exception
     */
    public CuatroCeroTresRequestException(String mensaje, Throwable exception) {
        super(mensaje);
    }

}

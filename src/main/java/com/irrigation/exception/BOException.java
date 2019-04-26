package com.irrigation.exception;

public class BOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BOException(String message) {
        super(message);
    }

    public BOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

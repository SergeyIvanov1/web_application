package com.ivanov_sergey.game.service.exceptions;

public class InvalidParameters extends RuntimeException {
    public InvalidParameters() {
        super();
    }

    public InvalidParameters(String message) {
        super(message);
    }

    public InvalidParameters(String message, Throwable cause) {
        super(message, cause);
    }
}

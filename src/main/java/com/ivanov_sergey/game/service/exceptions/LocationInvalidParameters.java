package com.ivanov_sergey.game.service.exceptions;

public class LocationInvalidParameters extends RuntimeException {
    public LocationInvalidParameters() {
        super();
    }

    public LocationInvalidParameters(String message) {
        super(message);
    }

    public LocationInvalidParameters(String message, Throwable cause) {
        super(message, cause);
    }
}

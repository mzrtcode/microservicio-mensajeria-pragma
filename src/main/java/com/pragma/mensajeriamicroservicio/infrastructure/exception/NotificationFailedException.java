package com.pragma.mensajeriamicroservicio.infrastructure.exception;

public class NotificationFailedException extends Exception{

    public NotificationFailedException(String message) {
        super(message);
    }
}

package com.alert_service.exception;

public class AlertNotFoundException extends RuntimeException{

    public AlertNotFoundException(String message) {
        super(message);
    }
}

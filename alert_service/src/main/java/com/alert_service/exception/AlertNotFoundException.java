package com.alert_service.exception;

public class AlertNotFoundException extends RuntimeException{

    public AlertNotFoundException(Long id) {
        super("Could not find alert with ID: " + id);
    }
}

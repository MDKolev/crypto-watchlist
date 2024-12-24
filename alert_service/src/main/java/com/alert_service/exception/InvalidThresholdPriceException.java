package com.alert_service.exception;

public class InvalidThresholdPriceException extends RuntimeException{

    public InvalidThresholdPriceException(String message) {
        super(message);
    }
}

package com.alert_service.exception;

public class InvalidThresholdPriceException extends RuntimeException{

    public InvalidThresholdPriceException(Double thresholdPrice) {
        super("Invalid threshold price - " + thresholdPrice);
    }
}

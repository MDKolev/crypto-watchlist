package com.alert_service.exception;

public class CoinNotFoundException extends RuntimeException{

    public CoinNotFoundException(String coinId) {
        super("Could not find coin with ID: " + coinId);
    }
}

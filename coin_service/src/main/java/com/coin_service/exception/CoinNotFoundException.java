package com.coin_service.exception;

public class CoinNotFoundException extends RuntimeException{

    public CoinNotFoundException(String id) {
        super("Could not find coin with ID: " + id);
    }
}

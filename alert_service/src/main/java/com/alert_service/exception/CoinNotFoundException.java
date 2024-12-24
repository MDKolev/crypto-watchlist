package com.alert_service.exception;

public class CoinNotFoundException extends RuntimeException{

    public CoinNotFoundException() {
        super("Coin with this ID does not exist!");
    }
}

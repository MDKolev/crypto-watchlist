package com.coin_service.exception;

public class NoCoinsToSaveException extends RuntimeException{

    public NoCoinsToSaveException() {
        super("No coins to save!");
    }
}

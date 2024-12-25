package com.watchlist_service.exception;

public class InvalidFiatCurrencyException extends RuntimeException{

    public InvalidFiatCurrencyException() {
        super("Invalid fiat currency! We support only USD, EUR, GBP.");
    }
}

package com.watchlist_service.entity;

import com.watchlist_service.exception.InvalidFiatCurrencyException;

public enum FiatCurrency {

    USD, EUR, GBP;

    public static FiatCurrency fromString(String value) {
        try {
            return FiatCurrency.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new InvalidFiatCurrencyException();
        }
    }
}

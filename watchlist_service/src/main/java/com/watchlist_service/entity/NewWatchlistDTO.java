package com.watchlist_service.entity;

import jakarta.validation.constraints.NotBlank;

public class NewWatchlistDTO {

    @NotBlank(message = "Watchlist name is required.")
    private String watchlistName;

    private FiatCurrency fiatCurrency;

    public String getWatchlistName() {
        return watchlistName;
    }

    public void setWatchlistName(String watchlistName) {
        this.watchlistName = watchlistName;
    }

    public FiatCurrency getFiatCurrency() {
        return fiatCurrency;
    }

    public void setFiatCurrency(String fiatCurrency) {
       this.fiatCurrency = FiatCurrency.fromString(fiatCurrency);
    }
}

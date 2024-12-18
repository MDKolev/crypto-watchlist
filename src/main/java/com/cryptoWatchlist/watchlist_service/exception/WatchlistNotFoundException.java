package com.cryptoWatchlist.watchlist_service.exception;

public class WatchlistNotFoundException extends RuntimeException {

    public WatchlistNotFoundException(String message) {
        super(message);
    }
}

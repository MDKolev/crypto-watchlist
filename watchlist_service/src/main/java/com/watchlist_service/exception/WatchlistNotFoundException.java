package com.watchlist_service.exception;

public class WatchlistNotFoundException extends RuntimeException {

    public WatchlistNotFoundException(Long id) {
        super("Could not find watchlist with ID: " + id);
    }
}

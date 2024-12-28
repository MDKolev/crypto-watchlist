package com.watchlist_service.exception;

public class WatchlistAlreadyExistException extends RuntimeException {
    public WatchlistAlreadyExistException(String watchlistName) {
        super("Watchlist with name '" + watchlistName + "' already exists!");
    }
}

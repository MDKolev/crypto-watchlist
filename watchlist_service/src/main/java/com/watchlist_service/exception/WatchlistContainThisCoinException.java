package com.watchlist_service.exception;

public class WatchlistContainThisCoinException extends RuntimeException {
    public WatchlistContainThisCoinException(String coin) {
        super("This watchlist already contain coin with name '" + coin +"'");
    }
}

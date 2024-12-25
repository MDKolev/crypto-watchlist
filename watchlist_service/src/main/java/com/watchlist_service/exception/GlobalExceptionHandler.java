package com.watchlist_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WatchlistNotFoundException.class)
    public ResponseEntity<Object> handleWatchlistNotFound(WatchlistNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(InvalidFiatCurrencyException.class)
    public ResponseEntity<Object> handleInvalidFiatCurrencyException(InvalidFiatCurrencyException exception) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
    }
}

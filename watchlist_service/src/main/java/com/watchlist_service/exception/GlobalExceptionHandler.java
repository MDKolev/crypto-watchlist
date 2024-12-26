package com.watchlist_service.exception;


import com.coin_service.exception.CoinNotFoundException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
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

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<String> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex) {
        return new ResponseEntity<>("Unrecognized field: " + ex.getPropertyName(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CoinNotFoundException.class)
    public ResponseEntity<String> handleCoinNotFoundException(CoinNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}

package com.coin_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoCoinsToSaveException.class)
    public ResponseEntity<String> handleNoCoinsToSaveException(NoCoinsToSaveException exception ) {
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(exception.getMessage());
    }

    @ExceptionHandler(CoinNotFoundException.class)
    public ResponseEntity<String> handleCoinNotFoundException(CoinNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}

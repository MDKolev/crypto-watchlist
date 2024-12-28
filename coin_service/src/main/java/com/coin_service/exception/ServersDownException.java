package com.coin_service.exception;


public class ServersDownException extends RuntimeException {

    public ServersDownException() {
        super("Servers are currently down. Please, try again later.");

    }
}

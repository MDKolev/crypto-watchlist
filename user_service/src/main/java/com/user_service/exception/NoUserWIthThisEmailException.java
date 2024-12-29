package com.user_service.exception;

public class NoUserWIthThisEmailException extends RuntimeException{

    public NoUserWIthThisEmailException(String email) {
        super("User with email '" + email + "' does not exist!");
    }

}

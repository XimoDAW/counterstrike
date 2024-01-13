package com.counterstrike.cs.exception;


public class InternalServerErrorException extends RuntimeException{
    private static final String DESCRIPTION = "Internal error";

    public InternalServerErrorException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}

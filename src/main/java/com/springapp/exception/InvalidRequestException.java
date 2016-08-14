package com.springapp.exception;

public class InvalidRequestException extends CustomException {
    public InvalidRequestException(String message, String code) {
        super(message, code);
    }
}

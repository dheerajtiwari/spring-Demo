package com.springapp.exception;

public class InvalidOperationException extends CustomException {
    public InvalidOperationException(String message, String code) {
        super(message, code);
    }
}

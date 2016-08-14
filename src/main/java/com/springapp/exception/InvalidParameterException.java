package com.springapp.exception;

public class InvalidParameterException extends CustomException {
  public InvalidParameterException(String message, String code) {
    super(message, code);
  }
}

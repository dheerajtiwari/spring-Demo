package com.springapp.exception;

public class NotFoundException extends CustomException {
  public NotFoundException(String message, String code) {
    super(message, code);
  }
}

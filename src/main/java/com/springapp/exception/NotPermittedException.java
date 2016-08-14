package com.springapp.exception;

public class NotPermittedException extends CustomException {
  public NotPermittedException(String message, String code) {
    super(message, code);
  }
}

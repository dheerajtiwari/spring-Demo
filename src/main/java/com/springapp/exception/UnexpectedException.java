package com.springapp.exception;

public class UnexpectedException extends CustomException {
  public UnexpectedException(String message, String code) {
    super(message, code);
  }
}

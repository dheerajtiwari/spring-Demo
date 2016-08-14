package com.springapp.exception;

public class InValidHeaderException extends CustomException {
  public InValidHeaderException(String message, String code) {
    super(message, code);
  }
}

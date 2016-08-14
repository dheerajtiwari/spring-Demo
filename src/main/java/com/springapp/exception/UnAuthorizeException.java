package com.springapp.exception;

public class UnAuthorizeException extends CustomException {
  public UnAuthorizeException(String message, String code) {
    super(message, code);
  }
}

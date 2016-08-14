package com.springapp.exception;

import lombok.Getter;

@Getter
public class CustomException extends Exception {
  private String code;

  public CustomException(String message, String code) {
    super(message);
    this.code = code;
  }
}

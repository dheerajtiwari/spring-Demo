/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.exception;

/**
 *
 * @author sweethome
 */
public class MissingServletRequestParameterException extends CustomException {
  public MissingServletRequestParameterException(String message, String code) {
    super(message, code);
  }
  
}

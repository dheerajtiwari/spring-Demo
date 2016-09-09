/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.controller;

import com.springapp.entities.ApiResponse;
import com.springapp.entities.ApiResponseError;
import com.springapp.exception.AlreadyExistException;
import com.springapp.exception.NotFoundException;
import com.springapp.exception.UnexpectedException;
import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class ExceptionHandlerController extends Exception {

  @InitBinder
  public void initBinder(WebDataBinder binder) {

    binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toLowerCase());
      }
    });
  }

  @ExceptionHandler(AlreadyExistException.class)
  public ResponseEntity<ApiResponse> unHandledExceptions(Exception e) {
    return new ResponseEntity(new ApiResponseError("Something went wrong, please try again later", "INTERNAL_SERVER_ERROR"),
            HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiResponse> notFound(NotFoundException e) {
    return new ResponseEntity(new ApiResponseError(e.getMessage(), e.getCode()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UnexpectedException.class)
  public ResponseEntity<ApiResponse> notFound(UnexpectedException e) {
    return new ResponseEntity(new ApiResponseError(e.getMessage(), e.getCode()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ApiResponse> invalidAuth(ConstraintViolationException e) {
    Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
    String violationMessage = "Invalid Parameters.";
    if (constraintViolations.size() > 0) {
      violationMessage = "Following Constraints failed : ";
      for (ConstraintViolation<?> constraintViolation : constraintViolations) {
        violationMessage += constraintViolation.getMessage() + " ";
      }
    }
    return new ResponseEntity(new ApiResponseError(violationMessage, "INVALID_PARAMETERS"), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse> invalidAuth(MethodArgumentNotValidException e) {
    final BindingResult bindingResult = e.getBindingResult();
    final List<ObjectError> allErrors = bindingResult.getAllErrors();
    String message = "";
    for (ObjectError es : allErrors) {
      final Object[] arguments = es.getArguments();
      message += es.getDefaultMessage();
    }
    return new ResponseEntity(new ApiResponseError(message, "INVALID_PARAMETERS"),
            HttpStatus.NOT_ACCEPTABLE);
  }
}

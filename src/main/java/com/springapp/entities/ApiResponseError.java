package com.springapp.entities;
import com.springapp.entities.ApiResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseError extends ApiResponse {
  String code;
  Object message;

  public ApiResponseError() {
    this.status = "error";
  }
  
  public ApiResponseError(Object error, String code) {
    this.message = error;
    this.code = code;
    this.status = "error";
  }
}

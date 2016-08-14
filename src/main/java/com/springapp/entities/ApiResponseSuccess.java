/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.entities;

import com.springapp.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseSuccess extends ApiResponse {
  Object body;
  
  public ApiResponseSuccess() {
    this.status = "success";
  }

  public ApiResponseSuccess(Object body) {
    this.status = "success";
    this.body = body;
  }
}

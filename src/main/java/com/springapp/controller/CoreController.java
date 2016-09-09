package com.springapp.controller;

import com.springapp.entities.ApiResponse;
import com.springapp.entities.ApiResponseSuccess;
import com.springapp.entities.StepOneRequest;
import com.springapp.exception.UnexpectedException;
import com.springapp.service.StepOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping(value = "sms")
public class CoreController {

  @Autowired
  StepOneService stepOneService;

  @RequestMapping(value = "/stepOne", method = RequestMethod.POST, produces = "application/json")
  @Transactional
  public ResponseEntity<ApiResponse> stepOne(@Valid @RequestBody StepOneRequest stepOneRequest) throws UnexpectedException {
    System.out.println("Inside stepOne.");
    stepOneService.requestStepOne(stepOneRequest);
    return new ResponseEntity(new ApiResponseSuccess("Added Successfully!"), OK);
  }


}

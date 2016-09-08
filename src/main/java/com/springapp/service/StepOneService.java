package com.springapp.service;

import com.springapp.entities.StepOneRequest;
import org.springframework.stereotype.Service;

@Service
public class StepOneService {

  public void requestStepOne(StepOneRequest stepOneRequest){
      System.out.println(stepOneRequest.getNumbers());
      System.out.println(stepOneRequest.getContent());
      System.out.println(stepOneRequest.getSender());

  }


  public void validateRequest(StepOneRequest stepOneRequest){

  }

}

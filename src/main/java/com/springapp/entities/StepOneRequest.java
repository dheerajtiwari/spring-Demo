package com.springapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StepOneRequest {

  @NotNull
  @Size(min=2, max=30,message = "Invalid Sender")
  public String sender;
  @NotNull
  public String content;
  @NotNull
  public String numbers;
}

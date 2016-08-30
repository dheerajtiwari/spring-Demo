package com.springapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;
  @Column(name = "username")
  private String userName;
  
  @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
  @Column(name = "email")
  @NotNull(message = "Email cannot be null")
  private String email;
  
  @Column(name = "address")
  private String address;
  
  @Column(name = "password")
  @Size(min = 6, max = 15 ,message = "Invalid Password")
  private String password;
  
  public User(String userName,String password,String email,String address){
    
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.address = address;
    
  }
}

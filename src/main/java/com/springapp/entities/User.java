package com.springapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
  @Column(name = "email")
  private String email;
  @Column(name = "address")
  private String address;
  @Column(name = "password")
  private String password;

}


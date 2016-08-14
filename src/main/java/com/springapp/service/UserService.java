package com.springapp.service;

import com.springapp.entities.User;

import java.util.List;

public interface UserService {
  public List<User> list();
  public boolean delete(User user);
  public boolean saveOrUpdate(User user);
  public User findUser(int id);
}

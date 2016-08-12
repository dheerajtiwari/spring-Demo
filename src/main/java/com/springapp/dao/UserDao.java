package com.springapp.dao;

import com.springapp.entities.User;

import java.util.List;

public interface UserDao {
  public List<User> list();
  public boolean delete(User user);
  public boolean saveOrUpdate(User user);



}

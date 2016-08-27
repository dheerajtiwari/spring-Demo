package com.springapp.serviceImpl;

import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import com.springapp.repository.UserRepository;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserRepository {

  @Autowired
  UserDao userDao;

  @Override
  public List<User> list() {
    return userDao.list();
  }

  @Override
  public boolean delete(User user) {
    return userDao.delete(user);
  }

  @Override
  public boolean saveOrUpdate(User user) {
    return userDao.saveOrUpdate(user);
  }
@Override
  public User findUser(int id) {
    return userDao.findUser(id);
  }
}

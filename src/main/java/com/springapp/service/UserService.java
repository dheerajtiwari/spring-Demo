package com.springapp.service;

import com.springapp.entities.User;
import com.springapp.entities.UserRequest;
import com.springapp.exception.NotFoundException;
import com.springapp.exception.UnexpectedException;
import com.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public void addUser(UserRequest userRequest) throws UnexpectedException {




    User user = new User(userRequest.getUserName(), userRequest.getPassword(), userRequest.getEmail(), userRequest.getAddress());

    if (!userRepository.saveOrUpdate(user)) {
      throw new UnexpectedException("Something went wrong.", "NOT_FOUND");
    }

  }




  public User getUser(int userId) throws NotFoundException {

    User user = userRepository.findUser(userId);

    if (user == null) {
      throw new NotFoundException("User not found.", "NOT_FOUND");
    }
    return user;
  }

  public void deleteUser(int userId) throws NotFoundException, UnexpectedException {

    User user = userRepository.findUser(userId);

    if (user == null) {
      throw new NotFoundException("User not found.", "NOT_FOUND");
    }
    if (!userRepository.delete(user)) {
      throw new UnexpectedException("Something went wrong.", "NOT_FOUND");
    }
  }

  public List<User> getAllUsers() throws NotFoundException {

    List<User> allUsers = userRepository.list();

    if (allUsers.size() < 1) {
      throw new NotFoundException("User not found.", "NOT_FOUND");
    }
    return allUsers;
  }

}

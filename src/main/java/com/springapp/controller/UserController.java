package com.springapp.controller;

import com.springapp.exception.CustomException;
import com.springapp.entities.ApiResponse;
import com.springapp.entities.ApiResponseSuccess;
import com.springapp.entities.User;
import com.springapp.entities.UserRequest;
import com.springapp.exception.AlreadyExistException;
import com.springapp.exception.NotFoundException;
import com.springapp.exception.UnexpectedException;
import com.springapp.repository.UserRepository;
import com.springapp.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(value = "users")
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  SessionFactory sessionFactory;

  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public ModelAndView getPage() {
    ModelAndView modelAndView = new ModelAndView("hello");
    return modelAndView;
  }

  @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json")
  @Transactional
  public ResponseEntity<ApiResponse> insertUser(@Valid @RequestBody UserRequest userRequest) throws UnexpectedException {
    userService.addUser(userRequest);
    return new ResponseEntity(new ApiResponseSuccess("Added Successfully!"), OK);
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  @Transactional
  public ResponseEntity<ApiResponse> getUser(@PathVariable(value = "userId") int userId) throws NotFoundException {
    return new ResponseEntity(new ApiResponseSuccess(userService.getUser(userId)), OK);
  }

  @RequestMapping(value = "/{userId}/delete", method = RequestMethod.DELETE)
  @Transactional
  public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "userId") int userId) throws NotFoundException, UnexpectedException {
    userService.deleteUser(userId);
    return new ResponseEntity(new ApiResponseSuccess("Deleted Successfully"), OK);
  }

  @RequestMapping(method = RequestMethod.GET)
  @Transactional
  public ResponseEntity<ApiResponse> getAllUsers() throws NotFoundException {
    return new ResponseEntity(new ApiResponseSuccess(userService.getAllUsers()), OK);
  }
}

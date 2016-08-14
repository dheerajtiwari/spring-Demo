package com.springapp.controller;

import com.springapp.exception.CustomException;
import com.springapp.entities.ApiResponse;
import com.springapp.entities.ApiResponseSuccess;
import com.springapp.entities.User;
import com.springapp.entities.UserRequest;
import com.springapp.exception.AlreadyExistException;
import com.springapp.exception.NotFoundException;
import com.springapp.exception.UnexpectedException;
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
  public ResponseEntity<ApiResponse> insertUser(@RequestBody UserRequest userRequest) throws UnexpectedException {
    Map map = new HashMap();
    User user = new User(userRequest.getUserName(), userRequest.getPassword(), userRequest.getEmail(), userRequest.getAddress());

    if (!userService.saveOrUpdate(user)) {
      throw new UnexpectedException("Something went wrong.", "NOT_FOUND");
    }
    return new ResponseEntity(new ApiResponseSuccess("Added Successfully!"), OK);
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  @Transactional
  public ResponseEntity<ApiResponse> getUser(@PathVariable(value = "userId") int userId) throws NotFoundException {
    User user = userService.findUser(userId);

    if (user == null) {
      throw new NotFoundException("User not found.", "NOT_FOUND");
    }

    return new ResponseEntity(new ApiResponseSuccess(user), OK);
  }

  @RequestMapping(value = "/{userId}/delete", method = RequestMethod.DELETE)
  @Transactional
  public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "userId") int userId) throws NotFoundException, UnexpectedException {
    User user = userService.findUser(userId);

    if (user == null) {
      throw new NotFoundException("User not found.", "NOT_FOUND");
    }
    if (!userService.delete(user)) {
      throw new UnexpectedException("Something went wrong.", "NOT_FOUND");
    }
    return new ResponseEntity(new ApiResponseSuccess("Deleted Successfully"), OK);
  }
  
  @RequestMapping(method = RequestMethod.GET)
  @Transactional
  public ResponseEntity<ApiResponse> getAllUsers() throws NotFoundException {
    List<User> allUsers = userService.list();

    if (allUsers.size() < 1) {
      throw new NotFoundException("User not found.", "NOT_FOUND");
    }

    return new ResponseEntity(new ApiResponseSuccess(allUsers), OK);
  }
}

package com.springapp.controller;

import com.springapp.entities.User;
import com.springapp.entities.UserRequest;
import com.springapp.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(value = "users")
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  SessionFactory sessionFactory;

  @RequestMapping(value = "/page",method = RequestMethod.GET)
  public ModelAndView getPage(){

    ModelAndView modelAndView = new ModelAndView("hello");
    return modelAndView;

  }

  @RequestMapping(value = "/insertUser",method = RequestMethod.POST,  produces="application/json")
  @Transactional
  public @ResponseBody Map<String,Object> insertUser(@RequestBody UserRequest userRequest){
    Map map = new HashMap();
    System.out.println("asdf");
    
    
      map.put("status","200");
      map.put("message",userRequest.getUserName());


    return map;
  }
}

package com.microblog.controller;

import com.microblog.model.User;
import com.microblog.service.Impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
  private UserServiceImpl userService;

  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  @ResponseBody
  public List<User> getUsers() {
    return userService.findAll();
  }

  @RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
  @ResponseBody
  public List<User> getUser(@PathVariable("userName") String name) {
    return userService.findByFirstName(name);
  }
}

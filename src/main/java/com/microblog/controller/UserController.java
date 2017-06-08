package com.microblog.controller;

import com.microblog.model.User;
import com.microblog.service.Impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
  private UserServiceImpl userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public List<User> getUsers() {
    return userService.findAll();
  }
}

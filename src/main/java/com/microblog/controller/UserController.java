package com.microblog.controller;

import com.microblog.model.User;
import com.microblog.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  @ResponseBody
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
  @ResponseBody
  public List<User> getUser(@PathVariable("firstName") String name) {
    return userRepository.findByFirstName(name);
  }

  @PutMapping
  public String insertUser(@RequestBody User user) {
    userRepository.insert(user);
    return "redirect:/";
  }

  @PostMapping
  public String updateUser(@RequestBody User user) {
    userRepository.save(user);
    return "redirect:/";
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") String id) {
    userRepository.delete(userRepository.findById(id));
  }
}

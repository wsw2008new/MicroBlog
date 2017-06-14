package com.microblog.controller;

import com.microblog.domain.User;
import com.microblog.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserServiceImpl userService;

	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUser(@PathVariable("firstName") String name) {
		return userService.findByFirstName(name);
	}

	@PostMapping(value = "/insert")
	public String insertUser(@RequestBody User user) {
		userService.insert(user);
		return "redirect:/";
	}

	@PutMapping(value = "/save")
	public String updateUser(@RequestBody User user) {
		userService.save(user);
		return "redirect:/";
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		userService.delete(userService.findById(id));
	}
}

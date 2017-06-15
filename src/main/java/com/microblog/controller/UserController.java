package com.microblog.controller;

import com.microblog.domain.User;
import com.microblog.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
	private UserServiceImpl userService;

	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "users/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "users/{firstName}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUser(@PathVariable("firstName") String name) {
		return userService.findByFirstName(name);
	}

	@PostMapping(value = "users/insert")
	public void insertUser(@RequestBody User user) {
		userService.insert(user);
	}

	@PutMapping(value = "users/save")
	public void updateUser(@RequestBody User user) {
		userService.save(user);
	}

	@DeleteMapping("users/delete")
	public void deleteUser(@RequestBody User user) {
		userService.delete(user);
	}
}

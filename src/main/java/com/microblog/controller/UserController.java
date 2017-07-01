package com.microblog.controller;

import com.microblog.domain.User;
import com.microblog.security.JwtTokenHandler;
import com.microblog.service.UserService;
import com.microblog.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private static Logger logger = LogManager.getLogger();

	@Qualifier("userServiceImpl")
	private final UserService userService;
	private final JwtTokenHandler jwtTokenHandler;

	@Autowired
	public UserController(UserServiceImpl userService, JwtTokenHandler jwtTokenHandler) {
		this.userService = userService;
		this.jwtTokenHandler = jwtTokenHandler;
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

	@PostMapping(value = "/save")
	public ResponseEntity insertUser(@Valid @RequestBody User user) {
		userService.insert(user);
		logger.info(user.toString() + " saved to database.");
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity(headers, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public void updateUser(@RequestBody User user) {
		userService.save(user);
	}

	@DeleteMapping("/delete")
	public void deleteUser(@RequestBody User user) {
		userService.delete(user);
		logger.info(user.toString() + " deleted from database.");
	}
}

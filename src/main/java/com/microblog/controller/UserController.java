package com.microblog.controller;

import com.microblog.model.User;
import com.microblog.security.JwtTokenHandler;
import com.microblog.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private static Logger logger = LogManager.getLogger();

	private final UserService userService;
	private final JwtTokenHandler jwtTokenHandler;

	@Autowired
	public UserController(@Qualifier("userServiceImpl") UserService userService, JwtTokenHandler jwtTokenHandler) {
		this.userService = userService;
		this.jwtTokenHandler = jwtTokenHandler;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		if (logger.isDebugEnabled())
			logger.debug("All users have been listed.");

		return userService.findAll();
	}

	@RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUser(@PathVariable("firstName") String name) {

		if (logger.isDebugEnabled()) {
			List<User> user = userService.findByFirstName(name);
			for (User users : user)
				logger.debug(users.toString());
			logger.debug("Users named by \"" + name + "\" have been listed.");
		}

		return userService.findByFirstName(name);
	}

	@PostMapping(value = "/save")
	public void insertUser(@RequestBody User user) {
		user.setCreatedDate(new Date());
		user.setEditedDate(new Date());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.insert(user);

		if (logger.isDebugEnabled())
			logger.debug(user.toString() + " saved to database.");
	}

	@PutMapping(value = "/update")
	public void updateUser(@RequestBody User user) {
		userService.save(user);
	}

	@DeleteMapping(value = "/delete")
	public void deleteUser(@RequestBody User user) {
		userService.delete(user);

		if (logger.isDebugEnabled())
			logger.debug(user.toString() + " deleted from database.");
	}
}
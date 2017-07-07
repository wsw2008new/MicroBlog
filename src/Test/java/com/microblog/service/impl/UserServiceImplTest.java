package com.microblog.service.impl;

import com.microblog.model.User;
import com.microblog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	@Qualifier(value = "userServiceImpl")
	private UserService userService;

	public void findAllByText() throws Exception {
		System.out.println("Matched users ***********");
		List<User> users = userService.findAllByText("deniz");

		for (User user : users)
			System.out.println(user.toString());

	}

	@Test
	public void findAll() throws Exception {
		System.out.println("All Users ***********");
		List<User> users = userService.findAll();

		for (User user : users)
			System.out.println(user.toString());
	}
}
package com.microblog.service;

import com.microblog.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
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
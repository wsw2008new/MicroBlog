package com.microblog.commandline;

import com.microblog.service.PostService;
import com.microblog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializerTest {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Autowired
	@Qualifier("postServiceImpl")
	private PostService postService;

	@Autowired
	private DataInitializer dataInitializer;


	@Test
	public void run() {
		dataInitializer.generatePosts().forEach(post -> postService.insert(post));
		dataInitializer.generateUsers().forEach(user -> userService.insert(userService.createUser(user)));
	}

}
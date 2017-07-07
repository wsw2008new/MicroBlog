package com.microblog;

import com.microblog.model.Role;
import com.microblog.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestData {
	@Autowired
	private MongoOperations mongoOperations;

	@Test
	public void generateUsers() {
		if (mongoOperations.collectionExists(User.class))
			mongoOperations.dropCollection(User.class);

		User[] users = new User[]{
			new User(
				"deniz1",
				"güzel1",
				"denizmaradona1",
				new BCryptPasswordEncoder().encode("password123"),
				"email@email.com",
				new Role("admin"),
				new Date(),
				new Date()
			),
			new User(
				"deniz2",
				"güzel2",
				"denizmaradona2",
				new BCryptPasswordEncoder().encode("password123"),
				"email@email.com",
				new Role(),
				new Date(),
				new Date()
			)
		};
		mongoOperations.insert(Arrays.asList(users), User.class);
	}
}
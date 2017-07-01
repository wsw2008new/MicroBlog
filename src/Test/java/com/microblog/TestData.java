package com.microblog;

import com.microblog.domain.Post;
import com.microblog.domain.Role;
import com.microblog.domain.User;
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
	public void generateRoles() {
		if (mongoOperations.collectionExists(Role.class))
			mongoOperations.dropCollection(Role.class);

		Role[] roles = new Role[] {
			new Role("admin"),
			new Role("user")
		};

		mongoOperations.insert(Arrays.asList(roles), Role.class);
	}

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
				new Role("user")
			),
			new User(
				"deniz2",
				"güzel2",
				"denizmaradona2",
				new BCryptPasswordEncoder().encode("password123"),
				new Role("user")
			),
			new User(
				"deniz3",
				"güzel3",
				"denizmaradona3",
				new BCryptPasswordEncoder().encode("password123"),
				new Role("user")
			)
		};
		mongoOperations.insert(Arrays.asList(users), User.class);
	}

	@Test
	public void generatePosts() {
		if (mongoOperations.collectionExists(Post.class))
			mongoOperations.dropCollection(Post.class);

		Post[] posts = new Post[]{
			new Post("Spring boot/security, angular2, jtw", "mongodb", "A blog content to combine some cool tech stack together using Spring boot/Spring Security, Angular-2 (still in beta CR-3), and Json WebToken. As of right now, Angular 2 is still in CR-3, their teams are moving fast and", new Date(), "deniz")
		};
		mongoOperations.insert(Arrays.asList(posts), Post.class);
	}
}
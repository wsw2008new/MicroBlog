package com.microblog.Mongorepo;

import com.microblog.model.Role;
import com.microblog.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void findAllBy() throws Exception {
		userRepository.insert(
			new User(
				"deniz",
				"güzel",
				"denizmaradona",
				new BCryptPasswordEncoder().encode("123"),
				"deniz@gmail.com",
				new Role("admin"),
				new Date(),
				new Date()
			))
		;
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny("deniz");
		List<User> users = userRepository.findAllBy(criteria);

		for (User user : users)
			System.out.println(user.toString());
	}

}
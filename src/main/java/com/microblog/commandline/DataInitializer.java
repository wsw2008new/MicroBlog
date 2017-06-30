package com.microblog.commandline;

import com.microblog.domain.Post;
import com.microblog.dto.UserDTO;
import com.microblog.service.impl.PostServiceImpl;
import com.microblog.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
	private UserServiceImpl userService;
	private PostServiceImpl postService;

	public DataInitializer(UserServiceImpl userService, PostServiceImpl postService) {
		this.userService = userService;
		this.postService = postService;
	}

	@Override
	public void run(String... args) throws Exception {
		generatePosts().stream().forEach(p -> postService.save(p));
		userService.createUser(new UserDTO("testuser@gmail.com", "password123", "vhoang"));
	}

	private List<Post> generatePosts() {
		List posts = new ArrayList();

		Post post1 = new Post();
		post1.setAuthor("vhoang55");
		post1.setContent("A blog content to combine some cool tech stack together using " +
			"Spring boot/Spring Security, Angular-2 (still in beta CR-3), and Json WebToken. As" +
			"of right now, Angular 2 is still in CR-3, their teams are moving fast and ");

		post1.setDate(new Date().toString());
		post1.setTitle("Spring boot/security, angular2, jtw");


		Post post2 = new Post();
		post2.setAuthor("vhoang55");
		post2.setContent("Angular 2 is a really cool web framework. It's built on top of Typescript" +
			" and RxJs. The web is moving fast, and seems like the industry is moving toward the" +
			" reactive programming model. It's a new shift in programming paradigm. <br> <br>" +
			" Look like the upcoming release of Spring 5 is also all about functional reactive reactive programming. <br>" +
			" Here is the link <a href=\"https://github.com/vhoang55/spring-rest-futures\"> Spring rest futures </a> to project that uses some of the cool libraries to enable" +
			" such reactive programming model. <br><br>" +
			" Definitely requires some deep learning curve but worth learning and can't wait for" +
			" the exiting time ahead. Can't wait to see where the industry is heading next."
		);
		post2.setDate(new Date().toString());
		post2.setTitle("Reactive programming model");

		posts.add(post1);
		posts.add(post2);

		return posts;

	}
}

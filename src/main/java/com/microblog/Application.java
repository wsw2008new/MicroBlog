package com.microblog;

import com.microblog.domain.User;
import com.microblog.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(final UserServiceImpl userService) {
		return args -> {
			userService.insert(new User("deniz", "güzel", "denizmaradona"));
			userService.insert(new User("ali kemal", "öcalan", "ekselansxox"));
			userService.insert(new User("burak", "ermeydan", "ermeydan"));
		};
	}
}

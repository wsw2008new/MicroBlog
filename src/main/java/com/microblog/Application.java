package com.microblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
	CommandLineRunner runner(final UserServiceImpl userService) {
		return args -> {
			byte i = 0;
			while (i < 10) {
				userService.insert(new User("deniz", "güzel", "denizmaradona"));
				userService.insert(new User("ali kemal", "öcalan", "ekselansxox"));
				userService.insert(new User("burak", "ermeydan", "ermeydan"));
				i++;
			}
		};
	}*/
}

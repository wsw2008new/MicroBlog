package com.microblog.utility;

import com.microblog.model.User;
import com.microblog.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
* CommandLineRunner is going to run when @SpringBootApplication ran. Like @PostConstruct
* */
@Component
public class DbSeeder implements CommandLineRunner {
  private UserRepository userRepository;

  public DbSeeder(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... strings) throws Exception {
    User user = new User("deniz", "güzel", "denizmaradona");
    User user1 = new User("ali", "öcalan", "alikemal");

    userRepository.deleteAll();
    userRepository.insert(user);
    userRepository.insert(user1);
  }
}

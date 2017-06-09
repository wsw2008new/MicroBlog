package com.microblog.utility;

import com.microblog.model.User;
import com.microblog.service.Impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
* CommandLineRunner is going to run when @SpringBootApplication ran. Like @PostConstruct
* */
@Component
public class DbSeeder implements CommandLineRunner {
  private UserServiceImpl userService;

  public DbSeeder(UserServiceImpl userService) {
    this.userService = userService;
  }

  @Override
  public void run(String... strings) throws Exception {
    User user = new User("deniz", "güzel", "denizmaradona");
    User user1 = new User("ali", "öcalan", "alikemal");

    userService.saveOrUpdate(user);
    userService.saveOrUpdate(user1);
  }
}

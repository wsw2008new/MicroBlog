package microblog.service.Impl;

import microblog.model.User;
import microblog.repo.UserRepository;
import microblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;


  @Override
  public List<User> getUserList() {
    return this.userRepository.findAll();
  }
}

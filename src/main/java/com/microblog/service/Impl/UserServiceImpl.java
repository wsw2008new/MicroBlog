package com.microblog.service.Impl;

import com.microblog.model.User;
import com.microblog.repo.UserRepository;
import com.microblog.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

  private UserRepository userRepository;

  public List<User> findByFirstName(String firstName) {
    return userRepository.findByFirstName(firstName);
  }
}

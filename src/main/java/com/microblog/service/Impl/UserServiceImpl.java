package com.microblog.service.Impl;

import com.microblog.model.User;
import com.microblog.repo.UserRepository;
import com.microblog.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements GenericService<User, String> {
  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void saveOrUpdate(User model) {
    userRepository.save(model);
  }

  @Override
  public void delete(User model) {
    userRepository.delete(model);
  }

  @Override
  public User find(String id) {
    return userRepository.findOne(id);
  }

  @Override
  public List<User> findByFirstName(String name) {
    return userRepository.findByFirstName(name);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }
}

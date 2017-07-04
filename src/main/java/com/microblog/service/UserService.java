package com.microblog.service;

import com.microblog.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;


public interface UserService extends UserDetailsService {
	List<User> findByFirstName(String name);

	List<User> findAllByText(String text);

	void insert(User user);

	void save(User user);

	void delete(User user);

	List<User> findAll();

	User findById(String id);

	Optional<User> findByUserName(String username);

}

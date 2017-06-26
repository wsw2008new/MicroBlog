package com.microblog.service;

import com.microblog.domain.User;

import java.util.List;

public interface UserService {
	List<User> findByFirstName(String name);

	List<User> findAllByText(String text);

	void insert(User user);

	void save(User user);

	void delete(User user);

	List<User> findAll();

	User findById(String id);

}

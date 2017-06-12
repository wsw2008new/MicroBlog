package com.microblog.service;

import com.microblog.domain.User;
import com.microblog.repo.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> {

	private UserRepository userRepository;

	public UserServiceImpl(MongoRepository<User, String> repository, UserRepository userRepository) {
		super(repository);
		this.userRepository = userRepository;
	}

	// new record
	public void insert(User user) {
		userRepository.insert(user);
	}

	// update record
	public void save(User user) {
		userRepository.save(user);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findByFirstName(String name) {
		return userRepository.findByFirstName(name);
	}

	public User findById(String id) {
		return userRepository.findById(id);
	}
}

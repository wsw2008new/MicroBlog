package com.microblog.service.impl;

import com.microblog.domain.User;
import com.microblog.repo.UserRepository;
import com.microblog.service.UserService;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userServiceImpl")
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findByFirstName(String name) {
		return userRepository.findByFirstName(name);
	}

	@Override
	public List<User> findAllByText(String text) {
		return this.userRepository.findAllBy(TextCriteria.forDefaultLanguage().matchingAny(text));
	}
}

package com.microblog.repo;

import com.microblog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends GenericRepository<User, String> {

	User findById(String id);

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);

	User findByUserName(String username);

	User deleteByUserName(String username);
}

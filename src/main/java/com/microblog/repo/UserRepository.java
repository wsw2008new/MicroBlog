package com.microblog.repo;

import com.microblog.domain.User;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends GenericRepository<User, String> {

	List<User> findByFirstName(String firstname);

	List<User> findByLastName(String lastname);

	User findByUserName(String username);

	User deleteByUserName(String username);

	List<User> findAllBy(TextCriteria textCriteria);
}

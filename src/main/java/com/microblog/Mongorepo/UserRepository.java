package com.microblog.Mongorepo;

import com.microblog.model.User;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component(value = "userMongoRepo")
@Repository
public interface UserRepository extends GenericRepository<User, String> {

	List<User> findByFirstName(String firstname);

	List<User> findByLastName(String lastname);

	Optional<User> findByUserName(String username);

	User deleteByUserName(String username);

	List<User> findAllBy(TextCriteria textCriteria);
}

package com.microblog.repo;

import com.microblog.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  List<User> findByFirstName(String firstName);

  List<User> findByLastName(String lastName);

  User findFirstByUserName(String username);

  User deleteByUserName(String username);
}

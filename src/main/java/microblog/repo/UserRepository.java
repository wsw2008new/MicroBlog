package microblog.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import microblog.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}

package boots.dao;

import org.springframework.data.repository.CrudRepository;
import boots.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}

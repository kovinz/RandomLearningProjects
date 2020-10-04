package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
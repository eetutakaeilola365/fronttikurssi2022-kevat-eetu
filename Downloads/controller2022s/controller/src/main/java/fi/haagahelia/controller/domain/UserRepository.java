package fi.haagahelia.controller.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}

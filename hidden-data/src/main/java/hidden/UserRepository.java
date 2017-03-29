package hidden;

import org.springframework.data.repository.CrudRepository;

/**
 * @author : Tomasz Czerwonka
 */
public interface UserRepository extends CrudRepository<User, Long> {
}

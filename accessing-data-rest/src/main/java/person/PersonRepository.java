package person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A repository to manage {@link Person} instances.
 *
 * @author : Tomasz Czerwonka
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastName(@Param("name") String name);

    List<Person> findByLastNameStartingWith(@Param("name") String name);

}

package relation.customer;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author : Tomasz Czerwonka
 */
@RepositoryRestResource(collectionResourceDescription = @Description("Collection of customers"))
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @RestResource(path = "/searchCustomerByGender", rel = "findByGender", description = @Description("Returns customers with specific gender"))
    List<Customer> findByGender(@Param("gender") String gender);

}

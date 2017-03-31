package relation.customer;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Tomasz Czerwonka
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{
}

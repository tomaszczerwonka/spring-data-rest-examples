package relation.order;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Tomasz Czerwonka
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{
}

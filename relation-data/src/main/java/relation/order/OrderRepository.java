package relation.order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Tomasz Czerwonka
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}

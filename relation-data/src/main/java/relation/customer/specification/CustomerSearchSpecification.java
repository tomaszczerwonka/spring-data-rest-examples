package relation.customer.specification;

import org.springframework.data.jpa.domain.Specification;
import relation.customer.Address;
import relation.customer.Address_;
import relation.customer.Customer;
import relation.customer.Customer_;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Tomasz Czerwonka
 */
public class CustomerSearchSpecification {


    public Specification<Customer> getCustomerSearchSpecification(String city) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!city.isEmpty()) {
                Join<Customer, Address> addressJoin = root.join(Customer_.address);
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(addressJoin.get(Address_.city), city)));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}

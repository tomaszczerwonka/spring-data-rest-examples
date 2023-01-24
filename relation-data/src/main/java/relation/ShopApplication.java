package relation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import relation.customer.Address;
import relation.customer.Customer;
import relation.customer.CustomerRepository;
import relation.customer.validator.CustomerValidator;
import relation.order.Item;
import relation.order.Order;
import relation.order.OrderRepository;

import java.math.BigDecimal;

/**
 * @author : Tomasz Czerwonka
 */
@SpringBootApplication
public class ShopApplication implements RepositoryRestConfigurer {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingRepositoryEventListener) {
        validatingRepositoryEventListener.addValidator("beforeCreate", new CustomerValidator());
    }

    @PostConstruct
    public void init() {
        Customer john = new Customer("John", "Red", Customer.Gender.MALE, new Address("Wall St.", "12111", "New York", null));
        customerRepository.save(john);
        Order firstOrder = new Order();
        firstOrder.add(new Item("tv", BigDecimal.valueOf(2500)));
        firstOrder.add(new Item("laptop", BigDecimal.valueOf(5000)));
        firstOrder.add(new Item("hdmi cable", BigDecimal.valueOf(5)));
        firstOrder.setCustomer(john);
        orderRepository.save(firstOrder);
    }
}

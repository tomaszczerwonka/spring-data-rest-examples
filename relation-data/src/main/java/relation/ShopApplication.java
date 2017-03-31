package relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import relation.customer.Address;
import relation.customer.Customer;
import relation.customer.CustomerRepository;
import relation.order.Item;
import relation.order.Order;
import relation.order.OrderRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * @author : Tomasz Czerwonka
 */
@SpringBootApplication
public class ShopApplication {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
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

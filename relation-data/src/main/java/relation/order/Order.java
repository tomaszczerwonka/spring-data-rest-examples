package relation.order;

import lombok.Data;
import relation.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Tomasz Czerwonka
 */
@Entity(name = "CustomerOrder")
@Data
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    private Customer customer;

    public Order add(Item item) {
        this.items.add(item);
        return this;
    }
}
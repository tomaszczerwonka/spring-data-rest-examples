package relation.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import relation.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Tomasz Czerwonka
 */
@Entity(name = "CustomerOrder")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    private Customer customer;

    public Order add(Item item) {
        this.items.add(item);
        return this;
    }
}
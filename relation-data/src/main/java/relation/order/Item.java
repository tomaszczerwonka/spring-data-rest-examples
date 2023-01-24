package relation.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author : Tomasz Czerwonka
 */
@Entity
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String description;
    private final BigDecimal price;

    public Item() {
        description = null;
        price = null;
    }
}

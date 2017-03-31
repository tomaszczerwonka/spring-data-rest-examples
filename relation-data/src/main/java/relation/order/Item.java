package relation.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @GeneratedValue
    @Id
    private Long id;
    private final String description;
    private final BigDecimal price;

    public Item() {
        description = null;
        price = null;
    }
}

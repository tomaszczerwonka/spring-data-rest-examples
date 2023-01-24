package relation.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author : Tomasz Czerwonka
 */
@Entity
@Data
@RequiredArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String street;
    private final String zipCode;
    private final String city;
    private final String state;

    Address() {
        this.street = null;
        this.zipCode = null;
        this.city = null;
        this.state = null;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return String.format("%s, %s %s, %s", street, zipCode, city, state);
    }
}


package relation.customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.Description;


@Entity
@Data
@RequiredArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Description("Customer first name")
    private final String firstName;
    @Description("Customer last name")
    private final String lastName;
    private final Gender gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private final Address address;

    Customer() {
        this.firstName = null;
        this.lastName = null;
        this.address = null;
        this.gender = null;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
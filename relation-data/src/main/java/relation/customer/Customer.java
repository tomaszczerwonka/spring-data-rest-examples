package relation.customer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class Customer {

    private @GeneratedValue
    @Id
    Long id;
    @Description("Customer first name")
    private final String firstName;
    @Description("Customer last name")
    private final String lastName;
    private final Gender gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)//
    private final Address address;

    Customer() {
        this.firstName = null;
        this.lastName = null;
        this.address = null;
        this.gender = null;
    }

    public enum Gender {
        MALE, FEMALE;
    }
}
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
    private final String firstname;
    @Description("Customer last name")
    private final String lastname;
//    @Description("The customer's sex")
    private final Gender gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)//
    private final Address address;

    Customer() {
        this.firstname = null;
        this.lastname = null;
        this.address = null;
        this.gender = null;
    }

    public enum Gender {
        MALE, FEMALE;
    }
}
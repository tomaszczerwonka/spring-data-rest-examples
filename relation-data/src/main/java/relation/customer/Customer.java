package relation.customer;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class Customer {

    private @GeneratedValue
    @Id
    Long id;
    private final String firstname, lastname;
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
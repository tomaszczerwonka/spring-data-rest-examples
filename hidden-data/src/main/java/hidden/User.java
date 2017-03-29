package hidden;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author : Tomasz Czerwonka
 */
@Entity
@Data
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @JsonIgnore
    private String password;

    private String[] roles;

    public User() {
        name = null;
    }
}

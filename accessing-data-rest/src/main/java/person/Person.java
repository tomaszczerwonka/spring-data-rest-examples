package person;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author : Tomasz Czerwonka
 */
@Entity
@Data
@RequiredArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NonNull
	@Size(min = 2, max = 50)
	@NotNull
	private String firstName;
	@NonNull
	@Size(min = 2, max = 50)
	@NotNull
	private String lastName;
	@Min( value = 1, message = "The value must be positive")
	@Max( value = 150, message = "We don't believe that you are so old")
	private int age = 0;

	public Person() {
		firstName = null;
		lastName = null;
	}
}

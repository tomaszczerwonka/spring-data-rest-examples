package person;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String firstName;
	@NonNull
	private String lastName;
	private int age = 0;

	public Person() {
		firstName = null;
		lastName = null;
	}
}

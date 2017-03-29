package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PersonApplication {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Person dave = new Person("Dave", "Matthews");
		dave.setAge(18);
		personRepository.save(dave);
		personRepository.save(new Person("Joana", "Blue"));
	}
}

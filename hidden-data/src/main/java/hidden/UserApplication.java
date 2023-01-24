package hidden;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author : Tomasz Czerwonka
 */
@SpringBootApplication
public class UserApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @PostConstruct
    public void init() {
        User admin = new User("admin");
        admin.setRoles(new String[]{"Super Admin"});
        admin.setPassword("admin123");
        userRepository.save(admin);
        User user = new User("normaluser");
        user.setRoles(new String[]{"Normal User"});
        userRepository.save(user);
        User powerUser = new User("poweruser");
        powerUser.setRoles(new String[]{"Normal User, Power User"});
        userRepository.save(powerUser);
    }
}

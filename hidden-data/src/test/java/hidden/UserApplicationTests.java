package hidden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Tomasz Czerwonka
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void deleteAllBeforeTests() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void shouldCreateEntity() throws Exception {

        mockMvc.perform(post("/users").content(
                "{\"name\": \"admin\"}")).andExpect(
                status().isCreated()).andExpect(
                header().string("Location", containsString("users/")));
    }

    @Test
    public void shouldRetrieveEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/users").content(
                "{\"name\": \"admin\"}")).andExpect(
                status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
                jsonPath("$.name").value("admin"));
    }

    @Test
    public void shouldRetrieveEntityPasswordProjection() throws Exception {
        User admin = new User("admin");
        admin.setPassword("admin123");
        userRepository.save(admin);

        mockMvc.perform(
                get("/users?projection={projection}", "passwords")).andExpect(
                status().isOk()).andExpect(
                jsonPath("$._embedded.users[0].password").value(
                        "admin123"));
    }

    @Test
    public void shouldRetrieveEntityUserProjection() throws Exception {
        mockMvc.perform(post("/users").content(
                "{\"name\": \"poweruser\",\n" +
                        "        \"roles\": [\n" +
                        "          \"Normal User, Power User\"\n" +
                        "        ]}")).andExpect(
                status().isCreated());

        mockMvc.perform(
                get("/users?projection={projection}", "virtual")).andExpect(
                status().isOk()).andExpect(
                jsonPath("$._embedded.users[0].userInfo").value(
                        "poweruser with roles Normal User, Power User"));
    }
}

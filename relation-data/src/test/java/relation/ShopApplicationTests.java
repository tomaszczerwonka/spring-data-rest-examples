package relation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import relation.customer.Customer;
import relation.customer.CustomerRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Tomasz Czerwonka, Sii
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ShopApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldReturnRepositoryIndex() throws Exception {

        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._links.customers").exists());
    }

    @Test
    public void shoulReturnCustomersWithWarsawCity() throws Exception {

        final String json = "{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\", \"gender\":\"" + Customer.Gender.MALE + "\", \"address\": { \"city\":\"Warsaw\"}}";
        MvcResult mvcResult = mockMvc.perform(post("/customers").content(json)).andExpect(status().isCreated()).andReturn();
    }
}

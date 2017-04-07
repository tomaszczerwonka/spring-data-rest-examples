package relation.customer.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import relation.customer.Customer;

/**
 * Validator for {@link Customer} entity.
 *
 * @author : Tomasz Czerwonka
 */
//@Component("beforeCreateCustomerValidator")
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;
        if (StringUtils.isEmpty(customer.getFirstName()) || customer.getFirstName().length() < 2) {
            errors.rejectValue("firstName", "-1", "firstName is to short");
        }

        if (StringUtils.isEmpty(customer.getLastName()) || customer.getLastName().length() < 2) {
            errors.rejectValue("lastName", "-2", "lastName is to short");
        }
    }
}

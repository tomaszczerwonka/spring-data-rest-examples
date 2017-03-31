package relation.customer.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import relation.customer.Customer;

/**
 * Validator for {@link Customer} entity.
 *
 * @author : Tomasz Czerwonka, Sii
 */
@Component("beforeCreateCustomerValidator")
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;
        if (StringUtils.isEmpty(customer.getFirstname()) || customer.getFirstname().length() < 2) {
            errors.rejectValue("firstname", "firstname.empty");
        } else if (StringUtils.isEmpty(customer.getLastname()) || customer.getLastname().length() < 2) {
            errors.rejectValue("lastname", "lastname.empty");
        }
    }
}
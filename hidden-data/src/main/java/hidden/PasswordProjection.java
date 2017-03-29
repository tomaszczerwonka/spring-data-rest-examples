package hidden;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author : Tomasz Czerwonka
 */
@Projection(name = "passwords", types = { User.class })
public interface PasswordProjection {

    String getPassword();
}

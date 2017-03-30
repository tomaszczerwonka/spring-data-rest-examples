package hidden;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * @author : Tomasz Czerwonka
 */
@Projection(name = "virtual", types = { User.class })
public interface UserProjection {

    @Value("#{target.name} with roles #{target.roles}")
    String getUserInfo();
}

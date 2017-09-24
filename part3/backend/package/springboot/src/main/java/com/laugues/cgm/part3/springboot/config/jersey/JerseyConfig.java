package com.laugues.cgm.part3.springboot.config.jersey;

import com.laugues.cgm.part3.springboot.security.JWTAuthenticationFilter;
import com.laugues.cgm.rest.api.DentistResource;
import com.laugues.cgm.rest.api.PingResource;
import com.laugues.cgm.rest.api.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Jersey configuration class
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PingResource.class);
        register(DentistResource.class);
        register(UserResource.class);
        register(JWTAuthenticationFilter.class);
    }

}

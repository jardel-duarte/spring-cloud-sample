package com.atlantico.desafio.proxy.intializer;

import com.atlantico.desafio.proxy.config.WebSecurityConfig;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(SecurityConfig.class, WebSecurityConfig.class);
    }
}

package com.laugues.cgm.part3.springboot.config.security;

import com.laugues.cgm.part3.springboot.security.HttpCORSFilter;
import com.laugues.cgm.part3.springboot.security.JWTAuthenticationFilter;
import com.laugues.cgm.part3.springboot.security.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security configuration to secure access to rest api endpoint
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ALL_PATH_WILDCARD = "/**/*";
    public static final String LOGIN_REST_PATH = "/login";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // dissable csrf because we use jwt token
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, ALL_PATH_WILDCARD).permitAll()
                .antMatchers(LOGIN_REST_PATH).permitAll()
                .antMatchers("/ping").permitAll()
                //TODO : remove dentist from permit all
                .antMatchers("/dentist").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter(LOGIN_REST_PATH, authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new HttpCORSFilter(), ChannelProcessingFilter.class);
    }

    /**
     * Configure global.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .authorities("USER_ROLE");

        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .authorities("ADMIN_ROLE", "USER_ROLE");
    }
}

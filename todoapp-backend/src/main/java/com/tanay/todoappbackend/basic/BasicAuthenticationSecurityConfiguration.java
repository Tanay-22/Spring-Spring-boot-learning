package com.tanay.todoappbackend.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration
{
    // Filter Chain
    // Authentication all request
    // basic authentication
    // disabling csrf
    // stateless rest api

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        return
            httpSecurity
                    .authorizeHttpRequests(
                            auth -> auth
                                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                    .anyRequest()
                                    .authenticated()
                    )
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session ->
                            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .csrf().disable()
                    .build();

    }
}

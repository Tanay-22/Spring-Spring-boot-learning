package com.tanay.todoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SecurityConfiguration
{
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        String username = "DogRaj";
        String password = "Mr. India";

        UserDetails userDetails = createNewUser(passwordEncoder, username, password);

        return new InMemoryUserDetailsManager(userDetails);
    }

    private static UserDetails createNewUser(Function<String, String> passwordEncoder, String username, String password)
    {
        UserDetails userDetails =  User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    // ALl urls are protected
    // A login form is shown for unauthorized requests
    // CSRF disable (Cross-Site Request Forgery (CSRF))
    // Frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception
    {
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        httpSecurity.formLogin(withDefaults());

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();
    }
}

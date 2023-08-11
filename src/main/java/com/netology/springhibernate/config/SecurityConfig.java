package com.netology.springhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requestMatcherRegistry
                        -> requestMatcherRegistry.requestMatchers(HttpMethod.GET, "/test").permitAll())
                .authorizeHttpRequests(requestMatcherRegistry
                        -> requestMatcherRegistry.anyRequest().authenticated())
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager users(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("READ")
                .build();

        UserDetails writer = User.withUsername("writer")
                .password(passwordEncoder.encode("writer"))
                .roles("WRITE")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("READ", "WRITE", "DELETE")
                .build();

        return new InMemoryUserDetailsManager(user, admin, writer);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

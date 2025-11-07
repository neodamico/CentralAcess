package com.example.centralAcess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // permite requisições POST via Insomnia/Postman
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // libera geral
                );

        return http.build();
    }
}

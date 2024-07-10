package com.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authRequest ->{
            authRequest.anyRequest().authenticated();
        });
        http.formLogin(Customizer.withDefaults());
        http.logout(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

}

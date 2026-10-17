package com.example.api_gateway.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfiguratiom {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity){
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeExchange(req-> req.pathMatchers("/register","/authenticate").permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer(oAuth2->oAuth2.jwt(Customizer.withDefaults()))
                .build();
    }
}

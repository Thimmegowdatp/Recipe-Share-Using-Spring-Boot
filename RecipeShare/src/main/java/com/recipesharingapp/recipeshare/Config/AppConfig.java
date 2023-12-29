package com.recipesharingapp.recipeshare.Config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.AuthorizeRequestsDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class AppConfig {
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http.sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/**").authenticated().
                        anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.configurationSource(CorsConfigurationSource))
                .httpBasic(withDefaults())
                .formLogin(withDefaults());

        return null;
    }
}

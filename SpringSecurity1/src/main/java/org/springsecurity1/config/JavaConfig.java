package org.springsecurity1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.Customizer;

@Configuration
@EnableWebSecurity
public class JavaConfig {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http){


        /* Disable the CSRF tokens */
        http.csrf(Customizer-> Customizer.disable());

        /*Enable the Auth form*/




        return http.build();
    }
}

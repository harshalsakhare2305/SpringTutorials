package org.springsecurity1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class JavaConfig {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http){


        /* Disable the CSRF tokens */
        http.csrf(Customizer-> Customizer.disable());

        /*Enable the Auth form*/
      //  http.formLogin(Customizer.withDefaults());


        //Enable access of Application to tools like postman
        http.httpBasic(Customizer.withDefaults());


        //To make Session as Stateless
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));



        return http.build();
    }
}

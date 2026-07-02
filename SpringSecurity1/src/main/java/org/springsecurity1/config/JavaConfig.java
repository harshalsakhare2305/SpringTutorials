package org.springsecurity1.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class JavaConfig {

    @Autowired
    private UserDetailsService userDetailService;


    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http){


        /* Disable the CSRF tokens */
        http.csrf(Customizer-> Customizer.disable());

        /*Enable the Auth form*/
      //  http.formLogin(Customizer.withDefaults());


        //Enable access of Application to tools like postman
        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(Customizer-> Customizer.requestMatchers("/register-user").permitAll().anyRequest().authenticated());


        //To make Session as Stateless
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
   public AuthenticationProvider getAuthprovider(){

        DaoAuthenticationProvider dao =new DaoAuthenticationProvider(
               userDetailService
       );

        dao.setPasswordEncoder(passwordEncoder());

       return dao;

   }




//    @Bean
//    public UserDetailsService createUserDetails(){
//        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("123456").roles("USER").build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("123456").roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }
}

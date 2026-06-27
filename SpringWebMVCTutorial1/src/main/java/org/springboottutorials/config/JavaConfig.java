package org.springboottutorials.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class JavaConfig {

    @Bean
    public LocalTime getTime(){
        return LocalTime.now();
    }
}

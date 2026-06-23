package org.springboottutorials.ioccontainer.greeting.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class JavaCofig {


    public JavaCofig() {
        System.out.println("THis is the Java Config Bean");
    }
    @Bean
    public LocalTime createTime(){

        return LocalTime.now();
    }
}

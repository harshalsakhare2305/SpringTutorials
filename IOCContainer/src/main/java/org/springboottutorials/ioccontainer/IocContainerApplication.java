package org.springboottutorials.ioccontainer;

import org.springboottutorials.ioccontainer.services.GreeatingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication   // @Component + @AutoConfiguration
public class IocContainerApplication {

    public static void main(String[] args) {

        ApplicationContext container =SpringApplication.run(IocContainerApplication.class, args);

        GreeatingService greet = container.getBean(GreeatingService.class);

        greet.greetingaction("Harshal");
    }

}

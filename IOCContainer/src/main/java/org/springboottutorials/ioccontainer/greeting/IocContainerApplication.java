package org.springboottutorials.ioccontainer.greeting;

import org.springboottutorials.ioccontainer.ecommerce.app.AmazonClass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication   // @Component + @AutoConfiguration
public class IocContainerApplication {

    public static void main(String[] args) {

        /** which classes are responsible for creating the IOC container in the Springboot Application?
        * ---->>  SpringApplication class which has the run method
        *
        * **/

        ApplicationContext container =SpringApplication.run(IocContainerApplication.class, args);

        AmazonClass amz = container.getBean(AmazonClass.class);
        amz.deliverProduct(8000);


//        GreeatingService greet = container.getBean(GreeatingService.class);
//
//        greet.greetingaction("Harshal");
    }

}

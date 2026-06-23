package org.springboottutorials.ioccontainer.ecommerce;

import org.springboottutorials.ioccontainer.ecommerce.app.AmazonClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class,args);

        AmazonClass amz = context.getBean(AmazonClass.class);

        amz.deliverProduct(8000);
    }
}

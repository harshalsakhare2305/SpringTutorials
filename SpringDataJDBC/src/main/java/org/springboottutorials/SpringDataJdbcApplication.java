package org.springboottutorials;

import org.springboottutorials.app.EmployeeInfo;
import org.springboottutorials.schema.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJdbcApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJdbcApplication.class, args);

        container.getBean(EmployeeInfo.class).input(new Employee(3,"Harshal","PNQ",22));
    }

}

package org.springboottutorials;

import org.springboottutorials.app.CompanyClass;
import org.springboottutorials.schema.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class SpringJdbcApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = run(SpringJdbcApiApplication.class, args);

  container.getBean(CompanyClass.class).getEmployeeList().forEach(e-> System.out.println(e));



    }

}

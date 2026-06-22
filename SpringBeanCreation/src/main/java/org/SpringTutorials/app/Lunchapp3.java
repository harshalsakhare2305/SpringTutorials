package org.SpringTutorials.app;

import org.SpringTutorials.services.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lunchapp3 {

    public static void main(String[] args) {

        ApplicationContext container =new ClassPathXmlApplicationContext("applicationconfig.xml");

        Employee e1 =container.getBean("e1", Employee.class);
        System.out.println(e1);

        Employee e2 = container.getBean("e2", Employee.class);
        System.out.println(e2);
    }
}

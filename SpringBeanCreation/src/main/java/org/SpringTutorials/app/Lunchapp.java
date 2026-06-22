package org.SpringTutorials.app;

import org.SpringTutorials.services.ICourse;
import org.SpringTutorials.services.SpringCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lunchapp {

    public static void main(String[] args) {


        ApplicationContext container = new ClassPathXmlApplicationContext("applicationconfig2.xml");

       MyClass springCourse = container.getBean(MyClass.class);

       springCourse.buyCourse(8000);
    }
}

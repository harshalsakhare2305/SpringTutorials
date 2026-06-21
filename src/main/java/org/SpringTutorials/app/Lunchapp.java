package org.SpringTutorials.app;

import org.SpringTutorials.services.ICourse;
import org.SpringTutorials.services.SpringCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lunchapp {

    public static void main(String[] args) {


        ApplicationContext container = new ClassPathXmlApplicationContext("applicationcontext.xml");

       ICourse springCourse = container.getBean(SpringCourse.class);

       springCourse.buyCourse(8000);
    }
}

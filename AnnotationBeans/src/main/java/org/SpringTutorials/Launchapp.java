package org.SpringTutorials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launchapp {
    public static void main(String[] args) {


        ApplicationContext container = new ClassPathXmlApplicationContext("applicationconfig.xml");
    }
}

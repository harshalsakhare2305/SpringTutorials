package org.SpringTutorials.app;

import org.SpringTutorials.services.ICourse;
import org.SpringTutorials.services.JavaCourse;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class Lunchapp2 {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("applicationcontext.xml");

        MyClass course = beanFactory.getBean(MyClass.class);

         boolean result= course.buyCourse(8000);

         if(result){
             System.out.println("Succuess");
         }else{
             System.out.println("Error");
         }
    }
}

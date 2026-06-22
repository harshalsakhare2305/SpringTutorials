package org.SpringTutorials.app;

import org.SpringTutorials.services.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClass {

    // Field Injection
//    @Autowired
//    @Qualifier("javaCourse")
    private ICourse course;



     // Constructor Injection
    // Qualifier is not applicable for the constructor but we can use for the argument in the constructor
    @Autowired

    public MyClass(@Qualifier("javaCourse") ICourse course){
        System.out.println("THis is the Constructor Injection");
        this.course=course;
    }

    public MyClass(){
        System.out.println("My class Constructor");
    }


//    @Autowired
//    @Qualifier("javaCourse")
    public void setCourse(ICourse course) {
        System.out.println("THis is Setter Injunction");
        this.course = course;
    }

    public boolean buyCourse(int amt){
        return course.buyCourse(amt);
    }

    public ICourse getCourse() {
        return course;
    }
}

package org.SpringTutorials.app;

import org.SpringTutorials.services.ICourse;

public class MyClass {

    private ICourse course;

    public MyClass(ICourse course){
        System.out.println("THis is the Constructor Injection");
        this.course=course;
    }

    public MyClass(){

    }

    public void setCourse(ICourse course) {
        System.out.println("THis is Setter Injunction");
        this.course = course;
    }

    public ICourse getCourse() {
        return course;
    }
}

package org.SpringTutorials.services;

public class JavaCourse implements ICourse{


    public JavaCourse() {
        System.out.println("This is the JavaCourse");
    }

    @Override
    public boolean buyCourse(int amt) {
        System.out.println("The amount of "+ amt + " is been for the java Course");
        return true;
    }
}

package org.SpringTutorials.services;

public class SpringCourse implements ICourse{

    public SpringCourse(){
        System.out.println("This is springCourse");
    }

    @Override
    public boolean buyCourse(int amt) {
        System.out.println("The amount of "+ amt + " is been paid for the SpringCourse");
        return true;
    }
}

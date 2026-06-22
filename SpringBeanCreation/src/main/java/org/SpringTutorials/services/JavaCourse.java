package org.SpringTutorials.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
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

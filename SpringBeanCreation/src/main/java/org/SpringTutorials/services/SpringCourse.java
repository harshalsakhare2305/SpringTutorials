package org.SpringTutorials.services;


import org.springframework.stereotype.Service;

@Service
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

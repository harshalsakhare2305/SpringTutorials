package org.springboottutorials.app;

import org.springboottutorials.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JavaRunner implements CommandLineRunner {


    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {

        studentRepo.save(new Student(1,"Harshal",22));
        System.out.println("The data inserted");
    }
}

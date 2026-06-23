package org.springboottutorials.ioccontainer.greeting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GreeatingService {

    @Autowired
    private LocalTime time;

    public GreeatingService(){
        System.out.println("This is the constructor of Greeting Service Bean ");
    }

    public void greetingaction(String name){
       int hrs = time.getHour();

       if(hrs<12) System.out.println("Good Morning "+name);
       else if(hrs<16) System.out.println("Good Afternoon "+name);
       else if(hrs<20) System.out.println("Good Evening "+name);
       else System.out.println("Good night"+name);


    }


}

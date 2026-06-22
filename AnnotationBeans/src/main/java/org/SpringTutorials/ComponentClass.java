package org.SpringTutorials;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ComponentClass {


    public ComponentClass() {
        System.out.println("THis is the Component Bean");
    }


    @Bean
    public Password doaction(){
        Password pass =new Password("SHA");
        pass.printPassWord();
        return pass;
    }
}

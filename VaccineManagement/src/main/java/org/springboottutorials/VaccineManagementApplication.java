package org.springboottutorials;

import org.springboottutorials.entity.Vaccine;
import org.springboottutorials.service.VaccineServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VaccineManagementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(VaccineManagementApplication.class, args);

        VaccineServiceImpl vaccineService = container.getBean(VaccineServiceImpl.class);

        vaccineService.addVaccine(new Vaccine(1,"Polio","WHO",156.02));


    }

}

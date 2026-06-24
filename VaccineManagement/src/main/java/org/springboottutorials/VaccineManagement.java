package org.springboottutorials;

import org.springboottutorials.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VaccineManagement {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(VaccineManagement.class, args);

        VaccineService pageorsortService = container.getBean(VaccineService.class);

        pageorsortService.findAllVaccineRecord(true,"name").forEach(v-> System.out.println(v));

      //  pageorsortService.findAllVaccinePageRecord(0,3).getContent().forEach(v-> System.out.println(v));
    }
}


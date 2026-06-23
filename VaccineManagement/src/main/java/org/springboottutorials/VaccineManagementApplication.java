package org.springboottutorials;

import org.springboottutorials.entity.Vaccine;
import org.springboottutorials.service.VaccineServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayDeque;
import java.util.ArrayList;

@SpringBootApplication
public class VaccineManagementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(VaccineManagementApplication.class, args);

        VaccineServiceImpl vaccineService = container.getBean(VaccineServiceImpl.class);

      //  vaccineService.addVaccine(new Vaccine(1,"Polio","WHO",156.02));

//        Vaccine v1 =new Vaccine(1,"Polio","WHO",156.02);
//        Vaccine v2 =new Vaccine(2,"CoVaxin","BharatBiotech",1500.00);
//        Vaccine v3 =new Vaccine(3,"CoviSheild","Serum",560.0);
//
//        ArrayList<Vaccine>vaccines =new ArrayList<>();
//
//        vaccines.add(v1);
//        vaccines.add(v2);
//        vaccines.add(v3);
//
//        vaccineService.addAllVaccines(vaccines).forEach(v-> System.out.println(v));
//
//        Vaccine v = vaccineService.findVaccineById(2);
//        System.out.println("Vaccine with id 2 is "+ v);
//
//        boolean status = vaccineService.isVacchineExist(5);
//
//        if(status) System.out.println("Yes");
//        else System.out.println("No");

        System.out.println(vaccineService.removeVaccineById(2));





    }

}

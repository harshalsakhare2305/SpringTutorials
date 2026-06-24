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

        Vaccine v1 =new Vaccine(6,"HIV","WHO",1026.02);
        Vaccine v2 =new Vaccine(7,"Dengue","Govt",112.156);
        Vaccine v3 =new Vaccine(8,"Malaria","Govt",165.15);
        Vaccine v4 =new Vaccine(9,"Typhoid","Govt",85.98);

        ArrayList<Vaccine>vaccines =new ArrayList<>();

        vaccines.add(v1);
        vaccines.add(v2);
        vaccines.add(v3);
        vaccines.add(v4);

        vaccineService.addAllVaccines(vaccines).forEach(v-> System.out.println(v));
//
//        Vaccine v = vaccineService.findVaccineById(2);
//        System.out.println("Vaccine with id 2 is "+ v);
//
//        boolean status = vaccineService.isVacchineExist(5);
//
//        if(status) System.out.println("Yes");
//        else System.out.println("No");

    //    System.out.println(vaccineService.removeVaccineById(2));





    }

}

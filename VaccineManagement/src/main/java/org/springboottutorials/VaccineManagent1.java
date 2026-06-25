package org.springboottutorials;

import org.springboottutorials.entity.Vaccine;
import org.springboottutorials.service.VaccineService2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VaccineManagent1 {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(VaccineManagent1.class, args);

        VaccineService2 service = container.getBean(VaccineService2.class);

      //  System.out.println(service.GetTheVaccineById(1));
//
//        List<Vaccine> vaccineList =new ArrayList<>();
//     //   Vaccine v1 =new Vaccine(6,"HIV","WHO",1026.02);
//       Vaccine v2 =new Vaccine(100,"Denge","Got",112.56);
//
//  //     vaccineList.add(v1);
//       vaccineList.add(v2);
//
//        System.out.println(service.RemoveVaccineInBatch(vaccineList));


           //Search Operation
       // service.fetchVaccineByName("Polio").forEach(v-> System.out.println(v));

        // Insert Operation

      //  service.AddnewVaccine(26,"Devi","Govt",45.02);

        //Update Opetation

      //  service.UpdateVaccinePriceByName("Devi",145.20);

        //Delete Op
        service.DeleteVaccineByOwner("WHO");

    }
}

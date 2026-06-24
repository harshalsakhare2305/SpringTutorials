package org.springboottutorials;

import org.springboottutorials.Result.Dynamic.ResultView1;
import org.springboottutorials.service.Dynamic.classes.VaccineServicess;
import org.springboottutorials.service.Staticpkg.classes.VaccineService;
import org.springboottutorials.service.Staticpkg.interfaces.IVaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StaticandDynamicProjection {
    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(StaticandDynamicProjection.class, args);

        //IVaccineService service = container.getBean("StaticVaccineService", VaccineService.class);

     //   service.findVaccinesbyPriceLessThan(200.00).forEach(v-> System.out.println(v.getName()+" "+v.getOwner()));

    //    service.findVaccinesByOwner("Govt").forEach(e-> System.out.println(e.getName()+" "+e.getOwner()));\

        VaccineServicess vcservice = container.getBean("vcservice", VaccineServicess.class);


           vcservice.findVaccinesPriceLessThan(200.00, ResultView1.class).forEach(v-> System.out.println(v.getName()+ "  "+v.getPrice()));
    }
}

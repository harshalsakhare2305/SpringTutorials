package org.springboottutorials.ioccontainer.ecommerce.app;

import org.springboottutorials.ioccontainer.ecommerce.service.IDelivery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AmazonClass {

    private IDelivery delivery;

     /**
      * Can we do Dependency Injection without AUTOWIRED ?
      * ---->> Yes by keeping only paramaterized constructor for the constructor injection
     **/
    public AmazonClass(@Qualifier("fedEx") IDelivery delivery) {
        this.delivery = delivery;
    }

    public boolean deliverProduct(int amt){
        return delivery.DeliverProduct(amt);
    }
}

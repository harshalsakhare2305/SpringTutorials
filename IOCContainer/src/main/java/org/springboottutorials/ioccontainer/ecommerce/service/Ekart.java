package org.springboottutorials.ioccontainer.ecommerce.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class Ekart implements IDelivery{

    public Ekart() {
        System.out.println("Ekart bean created");
    }

    @Override
    public boolean DeliverProduct(int amt) {
        System.out.println("THe product delived through Ekart and amount paid is "+amt);
        return true;
    }


}

package org.springboottutorials.ioccontainer.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public class FedEx implements IDelivery{


    public FedEx() {
        System.out.println("The FedEx Bean is created");
    }

    @Override
    public boolean DeliverProduct(int amt) {
        System.out.println("THe product is delivered successfully and amount paid is equal to "+ amt);
        return true;
    }
}

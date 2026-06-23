package org.springboottutorials.ioccontainer.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public interface IDelivery {

    public boolean DeliverProduct(int amt);
}

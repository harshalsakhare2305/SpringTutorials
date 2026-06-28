package org.springboottutorials.services;

import org.springboottutorials.model.Customer;

import java.util.List;

public interface ICustomerService {

    public List<Customer> getAllCustomerList();

    public void RegisternewCustomer(Customer customer);

    public Customer getCustomerByid(Long id);
}

package org.springboottutorials.services;

import org.springboottutorials.model.Customer;
import org.springboottutorials.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ICustomerServiceImpl implements ICustomerService{

    private ICustomerRepo repo;

    @Autowired
    public ICustomerServiceImpl setRepo(ICustomerRepo repo) {
        this.repo = repo;
        return this;
    }

    @Override
    public List<Customer> getAllCustomerList() {
        return (List<Customer>)repo.findAll();
    }

    @Override
    public void RegisternewCustomer(Customer customer) {
        repo.save(customer);
    }

    @Override
    public Customer getCustomerByid(Long id) {
        Optional<Customer> option = repo.findById(id.toString());
        return option.get();
    }

    @Override
    public void UpdateCustomerRecord(Customer customer) {
        repo.save(customer);
    }

    @Override
    public void DeleteCustomerRecord(Customer customer) {
        repo.delete(customer);
    }


}

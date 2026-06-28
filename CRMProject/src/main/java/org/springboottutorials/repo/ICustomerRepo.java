package org.springboottutorials.repo;

import org.springboottutorials.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo extends CrudRepository<Customer,String> {

}

package org.springboottutorials.repo;

import org.springboottutorials.entity.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface IVaccineRepo extends CrudRepository<Vaccine,Integer> {

}

package org.springboottutorials.repo;

import org.springboottutorials.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVacccineRepo extends JpaRepository<Vaccine,Integer> {


}

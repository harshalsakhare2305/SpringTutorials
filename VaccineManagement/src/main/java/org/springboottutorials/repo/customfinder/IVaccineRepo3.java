package org.springboottutorials.repo.customfinder;

import org.springboottutorials.Result.Static.ResultView;
import org.springboottutorials.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IVaccineRepo3 extends JpaRepository<Vaccine,Integer> {

    // for custom finder methods --> findBy+PropertyName(eg.cost,age)+keyword(lessthan)

    List<ResultView> findByPriceLessThanEqual(Double price);


}

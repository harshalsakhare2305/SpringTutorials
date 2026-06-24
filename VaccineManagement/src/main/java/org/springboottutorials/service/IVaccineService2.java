package org.springboottutorials.service;

import org.springboottutorials.entity.Vaccine;

import java.util.List;

public interface IVaccineService2 {

    Vaccine GetTheVaccineById(Integer id);

    String RemoveVaccineInBatch(List<Vaccine> vaccineList);
}

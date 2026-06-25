package org.springboottutorials.service;

import org.springboottutorials.entity.Vaccine;

import java.util.List;

public interface IVaccineService2 {

    Vaccine GetTheVaccineById(Integer id);

    String RemoveVaccineInBatch(List<Vaccine> vaccineList);

    public List<Vaccine> fetchVaccineByName(String name);

    public void AddnewVaccine(Integer id,String name,String owner,Double price);

    public void UpdateVaccinePriceByName(String name,Double newPrice);

    public void DeleteVaccineByOwner(String owner);
}

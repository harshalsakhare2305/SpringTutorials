package org.springboottutorials.service;

import org.springboottutorials.entity.Vaccine;
import org.springboottutorials.repo.IVacccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineService2 implements IVaccineService2{

    private IVacccineRepo repo;


    @Autowired
    public void setRepo(IVacccineRepo repo) {

        this.repo = repo;
    }


    @Override
    public Vaccine GetTheVaccineById(Integer id) {
        return repo.getReferenceById(id);
    }

    @Override
    public String RemoveVaccineInBatch(List<Vaccine> vaccineList) {
         repo.deleteAllInBatch(vaccineList);
         return "Record deleted successfully";
    }

    @Override
    public List<Vaccine> fetchVaccineByName(String name) {
        return repo.findVaccineByName(name);
    }

    @Override
    public void AddnewVaccine(Integer id, String name, String owner, Double price) {

        repo.InsertVaccine(id,name,owner,price);

        System.out.println("Data Inserted Successfully!!!");

    }

    @Override
    public void UpdateVaccinePriceByName(String name, Double newPrice) {
        repo.UpdateVaccinePriceByName(name,newPrice);
        System.out.println("Price is Updated Suceesfully!!!");
    }

    @Override
    public void DeleteVaccineByOwner(String owner) {
        repo.DeleteVaccineByOwner(owner);
        System.out.println("Vaccine Delelted Successfully");
    }


}

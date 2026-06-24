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
}

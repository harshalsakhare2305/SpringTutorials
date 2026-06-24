package org.springboottutorials.service;

import org.springboottutorials.entity.Vaccine;

import org.springboottutorials.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccineServiceImpl implements IVaccineService{

    private IVaccineRepo vaccineRepo;

    @Autowired
    public void setVaccineRepo(IVaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @Override
    public Vaccine addVaccine(Vaccine vaccine) {
       return vaccineRepo.save(vaccine);
    }

    @Override
    public Iterable<Vaccine> addAllVaccines(Iterable<Vaccine> vaccines) {
       return  vaccineRepo.saveAll(vaccines);
    }

    @Override
    public Vaccine findVaccineById(Integer id) {
        Optional<Vaccine> optional = vaccineRepo.findById(id);

        if(optional.isPresent()){
            return optional.get();
        }
        System.out.println("Vaccine with Id : "+ id + "Not Found");
        return null;
    }

    @Override
    public Boolean isVacchineExist(Integer id) {
        return vaccineRepo.existsById(id);
    }

    @Override
    public String removeVaccineById(Integer id) {
        Optional<Vaccine> option =vaccineRepo.findById(id);

        if(option.isPresent()){
            vaccineRepo.deleteById(id);

            return new String("Vaccine with id "+ id + " is removed successfully");
        }


        return "No such Vaccine Exists";
    }


}

package org.springboottutorials.service;

import org.springboottutorials.entity.Vaccine;

public interface IVaccineService {

    public Vaccine addVaccine(Vaccine vaccine);

    public Iterable<Vaccine> addAllVaccines(Iterable<Vaccine> vaccines);

    public Vaccine findVaccineById(Integer id);

    public Boolean isVacchineExist(Integer id);

    public String removeVaccineById(Integer id);





}

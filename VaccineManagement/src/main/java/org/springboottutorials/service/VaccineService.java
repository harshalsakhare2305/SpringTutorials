package org.springboottutorials.service;

import org.springboottutorials.entity.Vaccine;
import org.springboottutorials.repo.IVaccineRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineService implements IVaccineService1 {


    private IVaccineRepo1 repo;

    @Autowired
    public void setRepo(IVaccineRepo1 repo) {
        this.repo = repo;
    }

    @Override
    public List<Vaccine> findAllVaccineRecord(boolean isASC, String... properties) {
        Sort sort =Sort.by(isASC? Sort.Direction.ASC: Sort.Direction.DESC,properties);

        return (List<Vaccine>)repo.findAll(sort);

    }

    @Override
    public Page<Vaccine> findAllVaccinePageRecord(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno,pagesize);

        return repo.findAll(pageable);
    }
}

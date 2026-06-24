package org.springboottutorials.service.Staticpkg.classes;

import org.springboottutorials.Result.Static.ResultView;

import org.springboottutorials.repo.customfinder.IVaccineRepo3;
import org.springboottutorials.service.Staticpkg.interfaces.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StaticVaccineService")
public class VaccineService implements IVaccineService {

    private IVaccineRepo3 repo;

    @Autowired
    public void setRepo(IVaccineRepo3 repo) {
        this.repo = repo;
    }

    @Override
    public List<ResultView> findVaccinesbyPriceLessThan(Double price) {
        return repo.findByPriceLessThanEqual(price);
    }

    @Override
    public List<ResultView> findVaccinesByOwner(String owner) {
        return repo.findByOwner(owner);
    }
}

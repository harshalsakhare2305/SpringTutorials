package org.springboottutorials.service.Dynamic.classes;

import org.springboottutorials.Result.Dynamic.View;
import org.springboottutorials.repo.customfinder.IVaccineRepo3;
import org.springboottutorials.service.Dynamic.interfaces.IVaccineServicess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vcservice")
public class VaccineServicess implements IVaccineServicess {

    private IVaccineRepo3 repo;

    @Autowired
    public void setRepo(IVaccineRepo3 repo) {
        this.repo = repo;
    }

    @Override
    public <T extends View> List<T> findVaccinesPriceLessThan(Double price,Class<T> tClass) {
        return repo.findByPriceLessThan(price,tClass);
    }


}

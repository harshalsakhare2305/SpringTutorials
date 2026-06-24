package org.springboottutorials.service.Dynamic.interfaces;

import org.springboottutorials.Result.Dynamic.View;

import java.util.List;

public interface IVaccineServicess {

    public <T extends View> List<T> findVaccinesPriceLessThan(Double price,Class<T> tClass);
}

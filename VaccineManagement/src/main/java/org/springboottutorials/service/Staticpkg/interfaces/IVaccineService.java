package org.springboottutorials.service.Staticpkg.interfaces;

import org.springboottutorials.Result.Static.ResultView;

import java.util.List;

public interface IVaccineService {

    List<ResultView> findVaccinesbyPriceLessThan(Double price);

    List<ResultView> findVaccinesByOwner(String owner);
}

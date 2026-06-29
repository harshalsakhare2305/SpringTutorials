package org.RestTouristManagement.services;

import org.RestTouristManagement.exceptions.TouristNotFoundException;
import org.RestTouristManagement.model.Tourist;

import java.util.List;

public interface ITouristService {

    public List<Tourist> findAllTourist();

    public Tourist findToursitByid(Long id) throws TouristNotFoundException;

    public String registerTourist(Tourist tourist);

    public String updateTouristrecord(Long id,Tourist tourist) throws TouristNotFoundException;

    public String updateTouristrecord2(Tourist tourist) throws TouristNotFoundException;

    public String updateTouristBudget(Long id,Long newbudget)  throws TouristNotFoundException;


}

package org.RestTouristManagement.services;

import org.RestTouristManagement.exceptions.TouristNotFoundException;
import org.RestTouristManagement.model.Tourist;

import java.util.List;

public interface ITouristService {

    public List<Tourist> findAllTourist();

    public Tourist findToursitByid(Long id) throws TouristNotFoundException;

    public String registerTourist(Tourist tourist);


}

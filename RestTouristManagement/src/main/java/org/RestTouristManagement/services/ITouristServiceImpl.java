package org.RestTouristManagement.services;

import org.RestTouristManagement.exceptions.TouristNotFoundException;
import org.RestTouristManagement.model.Tourist;
import org.RestTouristManagement.repo.IToursitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ITouristServiceImpl implements ITouristService{


     private IToursitRepo repo;

     @Autowired
    public void setRepo(IToursitRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Tourist> findAllTourist() {
        return  (List<Tourist>) repo.findAll();
    }

    @Override
    public Tourist findToursitByid(Long id) throws TouristNotFoundException  {
        Optional<Tourist> option = repo.findById(id);

        if(option.isPresent()){
            return option.get();
        }else{
          throw new TouristNotFoundException("Tourist with the id : "+ id + " Not Found");
        }


    }

    @Override
    public String registerTourist(Tourist tourist) {
        Tourist t = repo.save(tourist);
         return new String("Tourist With id "+ t.getId() + " registered succesfully");
    }
}

package org.RestTouristManagement.services;

import org.RestTouristManagement.exceptions.TouristNotFoundException;
import org.RestTouristManagement.model.Tourist;
import org.RestTouristManagement.repo.IToursitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    public String updateTouristrecord(Long id,Tourist tourist) throws TouristNotFoundException {

        Optional<Tourist> option = repo.findById(id);

        if(option.isPresent()){
            tourist.setId(id);
            repo.save(tourist);
            return new String("Record is Updated Successfully");
        }else{
            throw new TouristNotFoundException("Tourist with the id : "+ id + " Not Found so Cant be Updated");
        }


    }


    @Override
    public String updateTouristrecord2(Tourist tourist) throws TouristNotFoundException {
        Optional<Tourist> option = repo.findById(tourist.getId()
        );

        if(option.isPresent()){
            repo.save(tourist);
            return new String("Record is Updated Successfully");
        }else{
            throw new TouristNotFoundException("Tourist with the id : "+ tourist.getId() + " Not Found so Cant be Updated");
        }

    }

    @Override
    public String updateTouristBudget(Long id, Long newbudget) throws TouristNotFoundException {

        Optional<Tourist> option = repo.findById(id);

        if(option.isPresent()){
            Tourist tourist = option.get();
            tourist.setBudget(newbudget);
            repo.save(tourist);
            return new String("Tourist with id : "+ id+ "Updated Successfully");
        }else{
            throw new TouristNotFoundException("Tourist with the id : "+ id + " Not Found so Cant be Updated");
        }
    }


}

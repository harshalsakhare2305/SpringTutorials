package org.springboottutorials.repo;

import org.springboottutorials.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IVacccineRepo extends JpaRepository<Vaccine,Integer> {

    @Query("from Vaccine where name=:name")
    public List<Vaccine> findVaccineByName(String name);

    @Transactional
    @Modifying
    @Query("Insert into Vaccine(id,name,owner,price) VALUES (:id,:name,:owner,:price)")
    public void InsertVaccine(Integer id,String name,String owner,Double price);

    @Transactional
    @Modifying
    @Query("Update Vaccine SET price=:newPrice where name=:name")
    public void UpdateVaccinePriceByName(String name,Double newPrice);

    @Transactional
    @Modifying
    @Query("Delete from Vaccine where owner=:owner")
    public void DeleteVaccineByOwner(String owner);

}

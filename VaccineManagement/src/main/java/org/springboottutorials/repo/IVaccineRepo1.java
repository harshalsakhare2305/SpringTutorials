package org.springboottutorials.repo;

import org.springboottutorials.entity.Vaccine;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IVaccineRepo1 extends PagingAndSortingRepository<Vaccine,Integer> {


}

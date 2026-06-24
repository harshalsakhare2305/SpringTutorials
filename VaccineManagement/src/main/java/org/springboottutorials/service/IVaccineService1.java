package org.springboottutorials.service;

import org.springboottutorials.entity.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IVaccineService1 {
    List<Vaccine> findAllVaccineRecord(boolean isASC,String ...properties);

    Page<Vaccine> findAllVaccinePageRecord(Integer pageno,Integer pagesize);
}

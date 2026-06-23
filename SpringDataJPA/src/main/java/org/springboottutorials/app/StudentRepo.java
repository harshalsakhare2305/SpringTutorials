package org.springboottutorials.app;

import org.springframework.data.repository.CrudRepository;

import org.springboottutorials.entity.Student;

public interface StudentRepo extends CrudRepository<Student,Integer> {


}
